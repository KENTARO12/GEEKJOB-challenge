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
public class UD_LoginConfirm extends HttpServlet {

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
        user ud = new user();//loginUserとしての情報
        
        String url = null;//遷移先のURL
        
        try (PrintWriter out = response.getWriter()) {
            user udAlt = new user();//入力フォームに入れた仮情報
            udAlt.setName(request.getParameter("name"));
            udAlt.setPassword(request.getParameter("pass"));
            if(hs.getAttribute("udAlt")!=null){
                hs.removeAttribute("udAlt");
            }
            hs.setAttribute("udAlt",udAlt);
            try{
             ud = user_tDAO.getInstance().select(udAlt);
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
            //sql文でselectし、該当結果がある場合、userIDは0以外になる。
            if(ud.getUserID()!=0){
                hs.setAttribute("loginUser",ud);
                if(hs.getAttribute("referer")!=null){
                    url = (String)hs.getAttribute("referer");
                }else{
                    url = "top.jsp";
                }
            }else{
                url = "ud_LoginDenied.jsp";
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (Exception e){
            System.out.println("エラーが発生しました："+e.toString());
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
