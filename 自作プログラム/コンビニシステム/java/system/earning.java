/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import beans.earningTotal;
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
import beans.returnNowDate;

/**
 *
 * @author guest1Day
 */
public class earning extends HttpServlet {

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
        ResultSet db_data = null;
        HttpSession hs = request.getSession();
        earningTotal total = new earningTotal();
        
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/self_stockcontrol?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","Kenneth","password");
            
            db_st = db_con.prepareStatement("SELECT * FROM earning WHERE DATE_FORMAT(datetime, '%y%m%d') LIKE DATE_FORMAT(?,'%y%m%d')");
            String strYear = request.getParameter("year");
            String strMonth = request.getParameter("month");
            if(strMonth.length()==1){
                strMonth = "0"+strMonth;
            }
            String strDay = request.getParameter("day");
            if(strDay.length()==1){
                strDay = "0"+strDay;
            }
            String strDate = strYear+"-"+strMonth+"-"+strDay;
            db_st.setString(1,strDate);
            db_data = db_st.executeQuery();
            ArrayList<item> shelf = new ArrayList<item>();
            while(db_data.next()){
                item item1 = new item();
                item1.setName(db_data.getString("name"));
                item1.setPrice(db_data.getInt("price"));
                item1.setType(db_data.getInt("type"));
                item1.setCode(db_data.getString("code"));
                item1.setNumber(db_data.getInt("soldnumber"));
                item1.setDate(db_data.getTimestamp("datetime"));
                shelf.add(item1);
            }
            if(hs.getAttribute("earningDetail")!=null){
                hs.removeAttribute("earningDetail");
            }
            hs.setAttribute("earningDetail",shelf);
            
            db_st = db_con.prepareStatement("SELECT sum(soldnumber*price) FROM earning WHERE DATE_FORMAT(datetime, '%y%m%d') LIKE DATE_FORMAT(?,'%y%m%d')");
            db_st.setString(1,strDate);
            db_data = db_st.executeQuery();
            while(db_data.next()){
                total.setTotal(db_data.getInt("sum(soldnumber*price)"));
            }
            
            db_st = db_con.prepareStatement("SELECT sum(soldnumber*price) FROM earning WHERE DATE_FORMAT(datetime, '%y%m%d') LIKE DATE_FORMAT(?,'%y%m%d') AND type=1");
            db_st.setString(1,strDate);
            db_data = db_st.executeQuery();
            while(db_data.next()){
                total.setType1(db_data.getInt("sum(soldnumber*price)"));
            }
            
            db_st = db_con.prepareStatement("SELECT sum(soldnumber*price) FROM earning WHERE DATE_FORMAT(datetime, '%y%m%d') LIKE DATE_FORMAT(?,'%y%m%d') AND type=2");
            db_st.setString(1,strDate);
            db_data = db_st.executeQuery();
            while(db_data.next()){
                total.setType2(db_data.getInt("sum(soldnumber*price)"));
            }
            
            db_st = db_con.prepareStatement("SELECT sum(soldnumber*price) FROM earning WHERE DATE_FORMAT(datetime, '%y%m%d') LIKE DATE_FORMAT(?,'%y%m%d') AND type=3");
            db_st.setString(1,strDate);
            db_data = db_st.executeQuery();
            while(db_data.next()){
                total.setType3(db_data.getInt("sum(soldnumber*price)"));
            }
            
            db_st = db_con.prepareStatement("SELECT sum(soldnumber*price) FROM earning WHERE DATE_FORMAT(datetime, '%y%m%d') LIKE DATE_FORMAT(?,'%y%m%d') AND type=4");
            db_st.setString(1,strDate);
            db_data = db_st.executeQuery();
            while(db_data.next()){
                total.setType4(db_data.getInt("sum(soldnumber*price)"));
            }
            
            db_st = db_con.prepareStatement("SELECT sum(soldnumber*price) FROM earning WHERE DATE_FORMAT(datetime, '%y%m%d') LIKE DATE_FORMAT(?,'%y%m%d') AND type=5");
            db_st.setString(1,strDate);
            db_data = db_st.executeQuery();
            while(db_data.next()){
                total.setType5(db_data.getInt("sum(soldnumber*price)"));
            }
            
            db_st = db_con.prepareStatement("SELECT sum(soldnumber*price) FROM earning WHERE DATE_FORMAT(datetime, '%y%m%d') LIKE DATE_FORMAT(?,'%y%m%d') AND type=6");
            db_st.setString(1,strDate);
            db_data = db_st.executeQuery();
            while(db_data.next()){
                total.setType6(db_data.getInt("sum(soldnumber*price)"));
            }
            
            db_st = db_con.prepareStatement("SELECT sum(soldnumber*price) FROM earning WHERE DATE_FORMAT(datetime, '%y%m%d') LIKE DATE_FORMAT(?,'%y%m%d') AND type=7");
            db_st.setString(1,strDate);
            db_data = db_st.executeQuery();
            while(db_data.next()){
                total.setType7(db_data.getInt("sum(soldnumber*price)"));
            }
            hs.setAttribute("earningNumber",total);
            
            returnNowDate searchDate = new returnNowDate();
            searchDate.setStrDate(strYear,strMonth,strDay);
            String str = searchDate.getStrDate();
            request.setAttribute("searchingDate", str);
            
            db_data.close();
            db_st.close();
            db_con.close();
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/earning.jsp");
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
