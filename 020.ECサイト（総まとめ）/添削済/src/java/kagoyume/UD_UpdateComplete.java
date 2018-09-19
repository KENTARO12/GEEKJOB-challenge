/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import beans.user;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import usefullObject.user_tDAO;

/**
 *
 * @author guest1Day
 */
public class UD_UpdateComplete extends HttpServlet {

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
        user ud2 = new user();//更新後の情報を格納するためのJavaBean。
        String url = null;//遷移先のurl。
        try (PrintWriter out = response.getWriter()) {
            user udAlt = new user();//DAOの引数としてのbean。
            user udAlt2 = new user();//検索結果数があるかどうかの確認。中身を使うことはない。
            udAlt.setName(request.getParameter("name"));
            udAlt.setPassword(request.getParameter("pass"));
            try{
                udAlt2 = user_tDAO.getInstance().select(udAlt);//同じアカウントがないかの判定に使う


                //sql文において、selectの該当結果が無い(重複がない)場合、userIDは0以外になる。
                if(udAlt2.getUserID()!=0){
                    url = "ud_UpdateDenied.jsp";
                }else{
                    url = "ud_UpdateComplete.jsp";
                    ud2.setName(request.getParameter("name"));
                    ud2.setPassword(request.getParameter("pass"));
                    ud2.setMail(request.getParameter("mail"));
                    ud2.setAddress(request.getParameter("address"));
                    ud2.setTotal(ud.getTotal());
                    java.util.Date time = new java.util.Date();
                    ud2.setNewDate(time);
                    ud2.setUserID(ud.getUserID());

                    user_tDAO.getInstance().update(ud2);

                    hs.removeAttribute("loginUser");
                    hs.setAttribute("loginUser",ud2);
                }
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
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }catch(Exception e){
            //その他のエラーが起きた場合の処理。エラーページにエラー文を渡して表示
            String error = "エラーが発生しました："+e.toString();
            System.out.println(error);
            request.setAttribute("error", error);
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
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
