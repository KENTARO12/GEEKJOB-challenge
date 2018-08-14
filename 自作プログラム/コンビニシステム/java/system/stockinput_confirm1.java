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
import java.sql.ResultSet;
import java.util.ArrayList;
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
public class stockinput_confirm1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*memo
    stockinput_list.jspで入力した商品と個数を、DBのearningとstockに反映させる。*/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        HttpSession hs = request.getSession();
        
        int shelfnum = Integer.parseInt(request.getParameter("shelfnum"));
        ArrayList<item> shelf = (ArrayList)hs.getAttribute("stockinput_list");
        item item1 = shelf.get(shelfnum);
        
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/self_stockcontrol?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","Kenneth","password");
            int subtraction = item1.getNumber()-Integer.parseInt(request.getParameter("num"));//(元の個数)－(入力した個数)
            int buy = Integer.parseInt(request.getParameter("num"));
            
            db_st = db_con.prepareStatement("UPDATE stock SET number=?,date=CURDATE() WHERE code=?");
            db_st.setInt(1,subtraction);
            db_st.setString(2,item1.getCode());
            int row = db_st.executeUpdate();
            
            db_st = db_con.prepareStatement("INSERT INTO earning(name,price,type,code,soldnumber,datetime) VALUES (?,?,?,?,?,NOW())");
            db_st.setString(1,item1.getName());
            db_st.setInt(2,item1.getPrice());
            db_st.setInt(3,item1.getType());
            db_st.setString(4,item1.getCode());
            db_st.setInt(5,buy);
            int row2 = db_st.executeUpdate();
            
            item item2 = new item();//これはstocksearch.jspにおいて、挿入結果の有無を知らせるものなので、nameとnumberだけ保管すればいい。
            item2.setName(item1.getName());
            item2.setNumber(Integer.parseInt(request.getParameter("num")));
            request.setAttribute("input",item2);
            
            db_st.close();
            db_con.close();
            
            hs.removeAttribute("searchresult");
            hs.removeAttribute("stockinput_list");
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/stockinput_search.jsp");
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
