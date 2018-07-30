<%-- 
    Document   : login
    Created on : 2018/07/23, 11:56:15
    Author     : guest1Day
--%>
<%@page import="beans.gototop"%>

<%
    gototop gto = gototop.getInstance();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン画面</title>
    </head>
    <body>
    <form action="loginConfirm" method="POST">
        名前:
        <input required type="text" name="name" value="">
        <br><br>

        パスワード:
        <input required type="text" name="pass" value="">
        <br><br>

        <input type="submit" name="btnSubmit" value="ログイン">
        
    </form>
        <br>
        <%=gototop.getInstance().home()%>
    </body>
</html>
