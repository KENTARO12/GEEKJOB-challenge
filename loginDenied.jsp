<%-- 
    Document   : loginDenied
    Created on : 2018/07/23, 13:09:12
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
        <title>ログイン失敗</title>
    </head>
    <body>
        <h3>ログインできませんでした<br>
        名前かパスワードが間違っている、もしくは既に削除された情報です</h3>
        <br>
        <a href="login.jsp">ログイン画面に戻る</a>
    </body>
    <br>
        <%=gototop.getInstance().home()%>
</html>
