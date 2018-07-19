package jums;

import beans.UserDataDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

/**
 *
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {
    

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
        
        PrintWriter out = response.getWriter();
        
        HttpSession hs = request.getSession();
        UserDataDTO uddalt = (UserDataDTO)hs.getAttribute("resultData");
        UserDataDTO udd = new UserDataDTO();
        
        Connection db_con = null;
        PreparedStatement db_st = null;
        try {
            request.setCharacterEncoding("UTF-8");
            //まずはjavabeansにデータをセットする
            //そのあとにgetですべてのデータを持ってきて、DBをupdateする。
            udd.setUserID(uddalt.getUserID());
            
            if(!"".equals(request.getParameter("name"))){
                udd.setName(request.getParameter("name"));
            }else{
                udd.setName(uddalt.getName());
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date birth = uddalt.getBirthday();
            String dateString = sdf.format(birth);
            
            if(!"".equals(request.getParameter("year"))){
                udd.setYear2(request.getParameter("year"));
            }else{
                udd.setYear2(dateString.substring(0,4));
            }
            
            if(!"".equals(request.getParameter("month"))){
                udd.setMonth2(request.getParameter("month"));
            }else{
                udd.setMonth2(dateString.substring(5,7));
            }
            
            if(!"".equals(request.getParameter("day"))){
                udd.setDay2(request.getParameter("day"));
            }else{
                udd.setDay2(dateString.substring(8,10));
            }
            
            if(!"".equals(request.getParameter("tell"))){
                udd.setTell(request.getParameter("tell"));
            }else{
                udd.setTell(uddalt.getTell());
            }
            
            /*
            typeを変えると文字化けする。
            udd.setType(uddalt.getType());は正常に動くので、uddは問題ない。
            String.valueOf(request.getParameter("type"))としても変わりはなかったので、型の違いではなさそう。
            文字コードが原因か？
            DBにも影響が出てる→表示段階(JSP)ではなく、beansに格納するとき(ここ)に問題がある？
            */
            if(!"".equals(request.getParameter("type"))){
                udd.setType(request.getParameter("type"));
            }else{
                udd.setType(uddalt.getType());
            }
            
            
            
            if(!"".equals(request.getParameter("comment"))){
                udd.setComment(request.getParameter("comment"));
            }else{
                udd.setComment(uddalt.getComment());
            }
            
            
            /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date birth = udd.getBirthday();
            String dateString = sdf.format(birth);*/
    
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","Kenneth","password");
            
            db_st = db_con.prepareStatement("UPDATE user_t SET name=?,birthday=?,tel=?,type=?,comment=?,newDate=? WHERE userID=?");
            db_st.setString(1,udd.getName());
            db_st.setString(2,udd.getBirthday2());
            db_st.setString(3,udd.getTell());
            db_st.setString(4,udd.getType());
            db_st.setString(5,udd.getComment());
            java.util.Date time = new java.util.Date();
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = sdf2.format(time);
            db_st.setString(6,strDate);
            db_st.setInt(7,udd.getUserID());
            
            int row = db_st.executeUpdate();
           
            db_st.close();
            db_con.close();
            
            hs.setAttribute("update",udd);
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/updateresult.jsp");
            rd.forward(request, response);
        }catch(Exception e){
            //データ挿入に失敗したらエラーページにエラー文を渡して表示
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        } finally {
            out.close();
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
