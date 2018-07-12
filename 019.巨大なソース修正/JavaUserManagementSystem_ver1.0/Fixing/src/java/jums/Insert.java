package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import beans.JumBean;
import javax.servlet.RequestDispatcher;

/**
 * insert.jspと対応するサーブレット
 * @author hayashi-s
 */
public class Insert extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        HttpSession hs = request.getSession(false);
        
        //ここでデータをjavabeansの形にして、セッションに格納したい
        JumBean jb = new JumBean();
        jb.setName(request.getParameter("name"));
        jb.setYear(request.getParameter("year"));
        jb.setMonth(request.getParameter("month"));
        jb.setDay(request.getParameter("day"));
        jb.setType(request.getParameter("type"));
        jb.setTel(request.getParameter("tel"));
        jb.setInfo(request.getParameter("comment"));
        
        hs.setAttribute("userInfo",jb);
        
        /*
        
        */
        
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/insertconfirm.jsp");
        rd.forward(request,response);
        
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
