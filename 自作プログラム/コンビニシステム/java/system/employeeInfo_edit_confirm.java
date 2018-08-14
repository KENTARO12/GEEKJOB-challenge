/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import beans.item;
import beans.userdata;
import java.io.IOException;
import java.io.PrintWriter;
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
public class employeeInfo_edit_confirm extends HttpServlet {

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
        Connection db_con = null;
        PreparedStatement db_st = null;
        HttpSession hs = request.getSession();
        
        userdata employee = (userdata)hs.getAttribute("selectedEmployee");
        userdata employee2 = new userdata();
        
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/self_stockcontrol?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","Kenneth","password");
            if(request.getParameter("name")!=null){
                db_st = db_con.prepareStatement("UPDATE employee SET name=? WHERE ID=?");
                String str = request.getParameter("name");
                db_st.setString(1,str);
                db_st.setInt(2,employee.getID());
                employee2.setName(str);
                employee2.setID(employee.getID());
                employee2.setPassword(employee.getPassword());
                employee2.setStatus(employee.getStatus());
            }else if(request.getParameter("id")!=null){
                db_st = db_con.prepareStatement("UPDATE employee SET ID=? WHERE name=?");
                int num = Integer.parseInt(request.getParameter("id"));
                db_st.setInt(1,num);
                db_st.setString(2,employee.getName());
                employee2.setName(employee.getName());
                employee2.setID(num);
                employee2.setPassword(employee.getPassword());
                employee2.setStatus(employee.getStatus());
            }else if(request.getParameter("pass")!=null){
                db_st = db_con.prepareStatement("UPDATE employee SET password=? WHERE ID=?");
                String str = request.getParameter("pass");
                db_st.setString(1,str);
                db_st.setInt(2,employee.getID());
                employee2.setName(employee.getName());
                employee2.setID(employee.getID());
                employee2.setPassword(str);
                employee2.setStatus(employee.getStatus());
            }else if(request.getParameter("status")!=null){
                db_st = db_con.prepareStatement("UPDATE employee SET status=? WHERE ID=?");
                int num = Integer.parseInt(request.getParameter("status"));
                db_st.setInt(1,num);
                db_st.setInt(2,employee.getID());
                employee2.setName(employee.getName());
                employee2.setID(employee.getID());
                employee2.setPassword(employee.getPassword());
                employee2.setStatus(num);
            }
                    
            int row = db_st.executeUpdate();
            db_st.close();
            db_con.close();
            request.setAttribute("edittingEmployee",employee2);
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/employee.jsp");
            rd.forward(request, response);
        }catch(Exception e){//JSPpageにforward出来ないので、無理やりここに処理を書く。もっといい方法もありそう。
            System.out.println("エラーが発生しました。以下の項目を確認してください。");
            System.out.println(e.getMessage());
            System.out.println("");
            System.out.println("<!DOCTYPE html>");
            System.out.println("<html>");
            System.out.println("<body>");
            System.out.println("<a href="+"top.jsp"+">トップへ戻る</a>");
            System.out.println("</body>");
            System.out.println("</html>");
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
