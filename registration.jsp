<%-- 
    Document   : registration
    Created on : 2018/07/20, 17:12:11
    Author     : guest1Day
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="beans.gototop"
        import="beans.user"%>

<%
    gototop gto = gototop.getInstance();
    HttpSession hs = request.getSession();
    user ud = (user)hs.getAttribute("userInfo");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規登録画面</title>
    </head>
    <%--if(hs.getAttribute("userInfo")==null){
    
    }else{
        フォームに初期値が入力されている状態
    }--%>
    <body>
    <form action="RegistrationConfirm" method="POST">
        名前:
        <input required type="text" name="name" value="">
        <br><br>

        パスワード:
        <input required type="text" name="pass" value="">
        <br><br>
        
        メールアドレス：
        <input required type="text" name="mail" value="">
        <br><br>
        
        お届け先住所：
        <input required type="text" name="address" value="">
        <br><br>

        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=gototop.getInstance().home()%>
    </body>
</html>
