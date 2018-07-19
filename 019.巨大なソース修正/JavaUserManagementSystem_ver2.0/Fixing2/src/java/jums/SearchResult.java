package jums;

import beans.UserDataDAO;
import beans.UserDataDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author hayashi-s
 */
public class SearchResult extends HttpServlet {

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
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        try{
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
            //フォームからの入力を取得して、JavaBeansに格納
            HttpSession hs = request.getSession();
            
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","Kenneth","password");
            
            db_st = db_con.prepareStatement("SELECT * FROM user_t WHERE name LIKE ? AND birthday LIKE ? AND type LIKE ?");
            
            String str = "%"+request.getParameter("name")+"%";
            db_st.setString(1,str);
            String str2 = "%"+request.getParameter("year")+"%";
            db_st.setString(2,str2);
            String str3 = "%"+request.getParameter("type")+"%";
            db_st.setString(3,str3);
            db_data = db_st.executeQuery();
            
            UserDataDTO search = new UserDataDTO();
            search.setName(request.getParameter("name"));
            search.setYear(request.getParameter("year"));
            search.setType(request.getParameter("type"));
            hs.setAttribute("Search",search);
            
            
            /*while(db_data.next()){
                out.println("名前:"+db_data.getString("name"));
                out.println("／生年:"+db_data.getString("birthday").substring(0,4));
                out.println("／種別:"+db_data.getString("type"));
                out.println("／登録日:"+db_data.getString("newDate").substring(0,10)+"<br>");
            }*/
            
            ArrayList<UserDataDTO> array = new ArrayList<UserDataDTO>();
            while(db_data.next()){
                UserDataDTO udb = new UserDataDTO();
                udb.setUserID(db_data.getInt("userID"));
                udb.setName(db_data.getString("name"));
                udb.setYear(db_data.getString("birthday").substring(0,4));
                String dateStr = db_data.getString("birthday");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                java.util.Date formatDate = sdf.parse(dateStr);
                udb.setBirthday(formatDate);
                udb.setType(db_data.getString("type"));
                udb.setTell(db_data.getString("tel"));
                udb.setComment(db_data.getString("comment"));
                udb.setUpDate(db_data.getString("newDate"));
                array.add(udb);
            }
            hs.setAttribute("SerchResult",array);
            
            
            db_data.close();
            db_st.close();
            db_con.close();        
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/searchresult.jsp");
            rd.forward(request,response);
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }finally{
            if(db_con != null){
                try{
                    db_con.close();
                }catch(Exception e_con){
                    System.out.println(e_con.getMessage());
                }
            }
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