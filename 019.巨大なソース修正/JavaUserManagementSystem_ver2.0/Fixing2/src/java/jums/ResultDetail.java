package jums;


import beans.UserDataDTO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class ResultDetail extends HttpServlet {

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
        HttpSession hs = request.getSession();
        UserDataDTO udb = new UserDataDTO();//arrayに入っているデータをみるため
        UserDataDTO udb2 = new UserDataDTO();
        ArrayList array = (ArrayList)hs.getAttribute("SerchResult");
        try{
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
            /*DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO searchData = new UserDataDTO();
            searchData.setUserID(2);
            UserDataDTO resultData = UserDataDAO .getInstance().searchByID(searchData);
            request.setAttribute("resultData", resultData);*/
            
            
            
            int id = Integer.parseInt(request.getParameter("id"));
            
            
            for(int i = 0;i<array.size();i++){
                udb = (UserDataDTO)array.get(i);
                if(udb.getUserID()==id){
                    udb2.setUserID(udb.getUserID());
                    udb2.setName(udb.getName());
                    udb2.setBirthday(udb.getBirthday());
                    udb2.setType(udb.getType());
                    udb2.setTell(udb.getTell());
                    udb2.setComment(udb.getComment());
                    udb2.setUpDate(udb.getUpDate());
                }
                //arraylistからuserID = int id のデータを選び出し、databeanに入れる
            }
            
            
            hs.setAttribute("resultData",udb2);
            

            request.getRequestDispatcher("/WEB-INF/resultdetail.jsp").forward(request, response);  
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
