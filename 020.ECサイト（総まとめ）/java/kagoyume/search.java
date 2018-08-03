/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import beans.itemdetail;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/*import org.json.JSONArray;
import org.json.JSONObject;*/

//urlクラス
//URLconnectionクラス
//jsonmapper

/**
 *
 * @author guest1Day
 */
public class search extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.setCharacterEncoding("UTF-8");
        
        //今回はjson文字列が一列のため通常のString型でも問題ない（けど、一応ね？）
        StringBuilder builder = new StringBuilder();
        //HttpClientのインスタンスを作る（HTTPリクエストを送るために必要）
        HttpClient client = new DefaultHttpClient();
        HttpSession hs = request.getSession();
        
        ObjectMapper mapper = new ObjectMapper();
        try {
            String query = request.getParameter("search");
            
            if(request.getParameter("search")==""){
                RequestDispatcher rd1 = request.getRequestDispatcher("top.jsp");
                rd1.forward(request,response);
            }
            /*String encodedquery = URLEncoder.encode(query, "UTF-8");//パーセントエンコーディング
            String MyAppID = "dj00aiZpPTR3ZGlrZURwRnZEOSZzPWNvbnN1bWVyc2VjcmV0Jng9ZjU-";//余談だが、Uri.builderというのもあるらしい。*/
            String str = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?appid=dj00aiZpPTR3ZGlrZURwRnZEOSZzPWNvbnN1bWVyc2VjcmV0Jng9ZjU-&hits=10&query="+query;
            
            //HttpGetのインスタンスを作る（GETリクエストを送るために必要）
            HttpGet httpGet = new HttpGet(str);
            
            //JDBCみたいにexecuteする。
            /*ここではint statusCode = response.getStatusLine().getStatusCode();とし、
            返却されたHTTPレスポンスの中のステータスコードを調べて、statusCodeが200だったらページが存在。404だったらNot found。500はInternal server errorなので
            switch文で処理を分岐させることもできる。）*/
            HttpResponse response2 = client.execute(httpGet);
            
            //レスポンスからHTTPエンティティを生成
            HttpEntity entity = response2.getEntity();
            //HTTPエンティティからコンテントを生成
            InputStream content = entity.getContent();
            //コンテントからInputStreamReaderを生成し、さらにBufferedReaderを作る
            //InputStreamReaderはテキストファイル（InputStream）を読み込む
                    
            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
            //BufferedReaderはテキストファイルを一行ずつ読み込む
            String line;
            //readerからreadline()で行を読んで、builder文字列(StringBuilderクラス)に格納していく。
            //今回はjson文字列が一列のため通常のString型でも問題ない（けど、なんか欲しいかなって。）
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
                    
            
                
            String str2 = builder.toString();
            JsonNode node = mapper.readTree(str2);
 
            ArrayList<itemdetail> array = new ArrayList<itemdetail>();
            for(int i = 0;i<10;i++){
                String num = String.valueOf(i);
                try{//get(num)がない場合、breakする。
                    itemdetail result = new itemdetail();
                    result.setName(node.get("ResultSet").get("0").get("Result").get(num).get("Name").asText());
                    result.setPrice(node.get("ResultSet").get("0").get("Result").get(num).get("Price").get("_value").asText());
                    result.setImage(node.get("ResultSet").get("0").get("Result").get(num).get("Image").get("Medium").asText());
                    result.setCode(node.get("ResultSet").get("0").get("Result").get(num).get("Code").asText());
                    result.setDesc(node.get("ResultSet").get("0").get("Result").get(num).get("Description").asText());
                    result.setRate(node.get("ResultSet").get("0").get("Result").get(num).get("Review").get("Rate").asText());
                    array.add(result);
                }catch(Exception e){
                    break;
                }
            }
            if(hs.getAttribute("staff")!=null){
                hs.removeAttribute("staff");
            }
            hs.setAttribute("staff",query);
            hs.setAttribute("result", array);
            request.getRequestDispatcher("searchresult.jsp").forward(request, response);
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
