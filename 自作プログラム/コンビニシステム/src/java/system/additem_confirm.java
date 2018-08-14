/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import beans.item;
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
public class additem_confirm extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/self_stockcontrol?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","Kenneth","password");
            db_st = db_con.prepareStatement("INSERT INTO stock (name,price,type,code,number,date,place) VALUES (?,?,?,?,?,CURDATE(),?)");
            int price = Integer.parseInt(request.getParameter("price"));
            int type = Integer.parseInt(request.getParameter("type"));
            int number = Integer.parseInt(request.getParameter("number"));
            db_st.setString(1,request.getParameter("name"));
            db_st.setInt(2,price);
            db_st.setInt(3,type);
            db_st.setString(4,request.getParameter("code"));
            db_st.setInt(5,number);
            db_st.setString(6,request.getParameter("place"));
            int row = db_st.executeUpdate();
            
            item additem = new item();
            additem.setName(request.getParameter("name"));
            additem.setPrice(price);
            additem.setType(type);
            additem.setCode(request.getParameter("code"));
            additem.setNumber(number);
            additem.setPlace(request.getParameter("place"));
            
            request.setAttribute("addingitem",additem);
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/additem.jsp");
            rd.forward(request,response);
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
