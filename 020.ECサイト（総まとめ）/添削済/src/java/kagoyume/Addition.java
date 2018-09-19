/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import beans.itemdetail;
import beans.user;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class Addition extends HttpServlet {

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
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpSession hs = request.getSession();
        ObjectMapper mapper = new ObjectMapper();
        try {
            user ud = (user)hs.getAttribute("loginUser");
            String strID = String.valueOf(ud.getUserID());
            ArrayList<itemdetail> cart = (ArrayList)hs.getAttribute("cart"+strID);
            ArrayList<itemdetail> newCart = new ArrayList<itemdetail>();
            
            String code = request.getParameter("id");
            String str = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup?appid=dj00aiZpPTR3ZGlrZURwRnZEOSZzPWNvbnN1bWVyc2VjcmV0Jng9ZjU-&responsegroup=medium&itemcode="+code;
            HttpGet httpGet = new HttpGet(str);
            HttpResponse response2 = client.execute(httpGet);
            HttpEntity entity = response2.getEntity();
            InputStream content = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
            String line;
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
            
            //cartの中身がない場合、cart.size()メソッド時にエラーをはく。
            try{//ここのtry文ってif文で書き換えられるの?
                for(int i = 0;i<cart.size();i++){
                    newCart.add(cart.get(i));
                }
            }catch(Exception e){
            }
            newCart.add(item);
            
            hs.removeAttribute("cart"+strID);
            hs.setAttribute("cart"+strID, newCart);
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
