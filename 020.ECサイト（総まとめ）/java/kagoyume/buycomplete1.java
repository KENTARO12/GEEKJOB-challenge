/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import beans.itemdetail;
import beans.user;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
public class buycomplete1 extends HttpServlet {

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
        user ud = (user)hs.getAttribute("loginUser");
        int userID=ud.getUserID();
        String strID = String.valueOf(userID);
        ArrayList array = (ArrayList)hs.getAttribute("cart"+strID);
        
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        try (PrintWriter out = response.getWriter()) {
            java.util.Date time = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = sdf.format(time);
            
            int type = Integer.parseInt(request.getParameter("type"));
            int total = 0;
                
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kagoyume_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","Kenneth","password");
            
            db_st = db_con.prepareStatement("INSERT INTO buy_t (userID,itemCode,type,buyDate,name,price)VALUES(?,?,?,?,?,?)");
            for(int i = 0;i<array.size();i++){
                itemdetail item = (itemdetail)array.get(i);
                db_st.setInt(1,ud.getUserID());
                db_st.setString(2,item.getCode());
                db_st.setInt(3,type);
                db_st.setString(4,strDate);
                db_st.setString(5,item.getName());
                db_st.setInt(6,Integer.valueOf(item.getPrice()));

                int row = db_st.executeUpdate();
                total += Integer.parseInt(item.getPrice());
            }
            
            db_st = db_con.prepareStatement("SELECT * FROM user_t WHERE userID=?");
            db_st.setInt(1,ud.getUserID());
            db_data = db_st.executeQuery();
            int totalAll = total;
            while(db_data.next()){
                totalAll += db_data.getInt("total");
            }
            db_data.close();
            
            db_st = db_con.prepareStatement("UPDATE user_t SET total=?,newDate=? WHERE userID=?");
            db_st.setInt(1,totalAll);
            db_st.setString(2,strDate);
            db_st.setInt(3,ud.getUserID());
            int row2 = db_st.executeUpdate();
            db_st.close();
            db_con.close();
            
            hs.removeAttribute("cart"+strID);
            
            String str = null;
            switch(type){
                case 1:
                    str="ご自宅へ配達";
                    break;
                case 2:
                    str="コンビニ店頭受け取り";
                    break;
                case 3:
                    str="営業所受け取り";
                    break;
            }
            request.setAttribute("type",str);
            request.setAttribute("total",total);
            request.getRequestDispatcher("buycomplete.jsp").forward(request, response);
        }catch (Exception e){
            System.out.println("接続時にエラーが発生しました："+e.toString());
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
