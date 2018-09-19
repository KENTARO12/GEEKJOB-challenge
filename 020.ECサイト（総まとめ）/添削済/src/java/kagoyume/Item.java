/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import beans.itemdetail;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

/**
 *
 * @author guest1Day
 */
public class Item extends HttpServlet {

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
            String code = null;//商品コード。
            if(request.getParameter("id")!=null){
                //searchresult.jspから飛んできたときはこっちの処理。
                code = request.getParameter("id");
                if(hs.getAttribute("lastsearch")!=null){//どの検索結果画面を最後に表示したかを管理するもの。
                    hs.removeAttribute("lastsearch");
                }
                hs.setAttribute("lastsearch",request.getHeader("Referer"));
            }else if(request.getParameter("cart")!=null){
                //cart.jspから飛んできた場合の処理。
                code = request.getParameter("code");
            }else{
                //item.jsp→ud_Login.jspに飛び、item.jspに戻るときはこっちの処理。
                code = (String)hs.getAttribute("keyword");
                hs.removeAttribute("keyword");
            }
            
            /*String encodedquery = URLEncoder.encode(query, "UTF-8");//パーセントエンコーディング
            String MyAppID = "dj00aiZpPTR3ZGlrZURwRnZEOSZzPWNvbnN1bWVyc2VjcmV0Jng9ZjU-";//余談だが、Uri.builderというのもあるらしい。*/
            String str = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup?appid=dj00aiZpPTR3ZGlrZURwRnZEOSZzPWNvbnN1bWVyc2VjcmV0Jng9ZjU-&responsegroup=medium&itemcode="+code;
            
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
            
            JsonNode layer = node.get("ResultSet").get("0").get("Result").get("0");

            itemdetail item = new itemdetail();
            item.setName(layer.get("Name").asText());
            item.setPrice(layer.get("Price").get("_value").asText());
            item.setImage(layer.get("Image").get("Medium").asText());
            item.setCode(layer.get("Code").asText());
            item.setDesc(layer.get("Description").asText());
            item.setRate(layer.get("Review").get("Rate").asText());
            
            
            //商品情報を"itemdetail"という名前でリクエストスコープに保管する。
            request.setAttribute("itemdetail", item);
            
            request.getRequestDispatcher("item.jsp").forward(request, response);
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
