<%-- 
    Document   : ud_Login
    Created on : 2018/07/30, 17:02:05
    Author     : guest1Day
--%>
<%@page import="beans.user"%>
<%@page import="beans.gototop"%>

<%
    HttpSession hs = request.getSession();
    String referer = request.getParameter("url");
    hs.setAttribute("referer",referer);
    
    //item.jspから飛んできた場合、商品コードも一緒に飛ばしているため、そのコードをセッションに保管する。
    if(request.getParameter("id")!=null){
        request.setCharacterEncoding("UTF-8");
        String keyword = request.getParameter("id");
        if(hs.getAttribute("keyword")!=null){
            hs.removeAttribute("keyword");
        }
        hs.setAttribute("keyword",keyword);
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン画面</title>
    </head>
    <body>
    <form action="UD_LoginConfirm" method="POST">
    <%if(hs.getAttribute("udAlt")!=null){
        user ud = (user)hs.getAttribute("udAlt");
    %>
        名前:
        <input required type="text" name="name" value="<%=ud.getName()%>"><br><br>
        パスワード:
        <input required type="text" name="pass" value="<%=ud.getPassword()%>"><br><br>
    <%}else{%>
        名前:
        <input required type="text" name="name" value=""><br><br>
        パスワード:
        <input required type="text" name="pass" value=""><br><br>
    <%}%>
        <input type="submit" name="btnSubmit" value="ログイン">
    </form>
        <br>
        <%=gototop.getInstance().home()%>
    </body>
</html>
