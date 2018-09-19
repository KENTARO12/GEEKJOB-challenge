<%-- 
    Document   : ud_Registration
    Created on : 2018/07/30, 17:00:27
    Author     : guest1Day
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="beans.gototop"
        import="beans.user"%>

<%
    HttpSession hs = request.getSession();
    if(request.getParameter("url")!=null){
        String referer = request.getParameter("url");
        hs.setAttribute("referer",referer);
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規登録画面</title>
    </head>
    <body>
    <form action="UD_RegistrationConfirm" method="POST">
    <%if(hs.getAttribute("udAlt")!=null){
        user ud = (user)hs.getAttribute("udAlt");
    %>
        名前:
        <input required type="text" name="name" value="<%=ud.getName()%>">
        ＊入力必須フォームです<br><br>

        パスワード:
        <input required type="text" name="pass" value="<%=ud.getPassword()%>">
        ＊入力必須フォームです<br><br>
        
        メールアドレス：
        <input required type="text" name="mail" value="<%=ud.getMail()%>">
        ＊入力必須フォームです<br><br>
        
        お届け先住所：
        <input required type="text" name="address" value="<%=ud.getAddress()%>">
        ＊入力必須フォームです<br><br>
    <%}else{%>
        名前:
        <input required type="text" name="name" value="">
        ＊入力必須フォームです<br><br>

        パスワード:
        <input required type="text" name="pass" value="">
        ＊入力必須フォームです<br><br>
        
        メールアドレス：
        <input required type="text" name="mail" value="">
        ＊入力必須フォームです<br><br>
        
        お届け先住所：
        <input required type="text" name="address" value="">
        ＊入力必須フォームです<br><br>
    <%}%>
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=gototop.getInstance().home()%>
    </body>
</html>
