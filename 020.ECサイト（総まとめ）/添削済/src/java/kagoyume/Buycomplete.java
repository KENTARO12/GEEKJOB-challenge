/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import beans.historybean;
import beans.itemdetail;
import beans.user;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import usefullObject.buy_tDAO;
import usefullObject.user_tDAO;

/**
 *
 * @author guest1Day
 */
public class Buycomplete extends HttpServlet {

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
        String strID = String.valueOf(ud.getUserID());
        ArrayList<itemdetail> array = (ArrayList)hs.getAttribute("cart"+strID);
        String url = null;//遷移先のURL。
        
        try (PrintWriter out = response.getWriter()) {
            java.util.Date time = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = sdf.format(time);
            
            int type = Integer.parseInt(request.getParameter("type"));
            try{
                buy_tDAO.getInstance().insert(ud.getUserID(),type,array);

                ArrayList<historybean> total = buy_tDAO.getInstance().select(ud.getUserID());//総購入金額の計算
                int totalAll = 0;
                for(int i = 0;i<total.size();i++){
                    totalAll += total.get(i).getPrice();
                }

                user ud2 = new user();//"loginUser"の総購入金額を更新する。
                ud2.setUserID(ud.getUserID());
                ud2.setName(ud.getName());
                ud2.setPassword(ud.getPassword());
                ud2.setMail(ud.getMail());
                ud2.setAddress(ud.getAddress());
                ud2.setTotal(totalAll);
                ud2.setNewDate(time);

                hs.removeAttribute("loginUser");
                hs.setAttribute("loginUser",ud2);

                user_tDAO.getInstance().update(ud2);//DB上のuser_tテーブルの書き換え。
            }catch(ParseException e){
                //データの変換に失敗したらエラーページにエラー文を渡して表示
                String error = "DAOにおいて、データ変換時にエラーが発生しました："+e.toString();
                System.out.println(error);
                request.setAttribute("error", error);
                url = "error.jsp";
            }catch(SQLException e){
                //sql周りで失敗したら(入力内容が長すぎ、など)エラーページにエラー文を渡して表示
                String error = null;//エラー内容をもっと細分化すべき。
                if(e.toString().contains("Data too long")){
                    error = "入力した内容が長すぎます："+e.toString();
                }else{
                    error = e.toString();
                }
                System.out.println(error);
                request.setAttribute("error", error);
                url = "error.jsp";
            }
            
            int lastTotal = 0;//カートの中身の合計金額を算出する。
            for(int i = 0;i<array.size();i++){
                lastTotal += Integer.parseInt(array.get(i).getPrice());//"今回の"総購入金額。
            }
            hs.removeAttribute("cart"+strID);//カートの中身をクリアする。
            
            String str = null;
            //配送方法の表示
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
            request.setAttribute("total",lastTotal);
            url = "buycomplete.jsp";
            request.getRequestDispatcher("buycomplete.jsp").forward(request, response);
        }catch (Exception e){
            System.out.println("接続時にエラーが発生しました："+e.toString());
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
