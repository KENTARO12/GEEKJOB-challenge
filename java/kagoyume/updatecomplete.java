/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import beans.user;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
public class updatecomplete extends HttpServlet {

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
        
        HttpSession hs = request.getSession();
        user ud = (user) hs.getAttribute("loginUser");
        Connection db_con = null;
        PreparedStatement db_st = null;
        
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kagoyume_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","Kenneth","password");
            int id2 = Integer.parseInt(request.getParameter("id2"));
            
            switch (id2) {
                case 1:
                    {
                        db_st = db_con.prepareStatement("UPDATE user_t SET name=? WHERE userID=?");
                        db_st.setString(1,request.getParameter("name"));
                        db_st.setInt(2,ud.getUserID());//ここでエラーになる。
                        int row = db_st.executeUpdate();
                        ud.setName(request.getParameter("name"));//ここでbeanの値をrequest.getParameter("name")に更新したい。これでいいの？
                        break;
                    }
                case 2:
                    {
                        db_st = db_con.prepareStatement("UPDATE user_t SET password=? WHERE userID=?");
                        db_st.setString(1,request.getParameter("pass"));
                        db_st.setInt(2,ud.getUserID());
                        int row = db_st.executeUpdate();
                        ud.setPassword(request.getParameter("pass"));
                        break;
                    }
                case 3:
                    {
                        db_st = db_con.prepareStatement("UPDATE user_t SET mail=? WHERE userID=?");
                        db_st.setString(1,request.getParameter("mail"));
                        db_st.setInt(2,ud.getUserID());
                        int row = db_st.executeUpdate();
                        ud.setMail(request.getParameter("mail"));
                        break;
                    }
                case 4:
                    {
                        db_st = db_con.prepareStatement("UPDATE user_t SET address=? WHERE userID=?");
                        db_st.setString(1,request.getParameter("address"));
                        db_st.setInt(2,ud.getUserID());
                        int row = db_st.executeUpdate();
                        ud.setAddress(request.getParameter("address"));
                        break;
                    }
                /*default:
                    RequestDispatcher rd = request.getRequestDispatcher("UpdateDenied.jsp");
                    rd.forward(request, response);
                    break;*/
            }
            
            db_st.close();
            db_con.close();
            
            RequestDispatcher rd = request.getRequestDispatcher("UpdateComplete.jsp");
            rd.forward(request, response);
        }catch(Exception e){
            //データ挿入に失敗したらエラーページにエラー文を渡して表示
            request.setAttribute("error", e.toString());
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
