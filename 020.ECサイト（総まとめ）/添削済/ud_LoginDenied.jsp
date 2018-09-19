<%-- 
    Document   : ud_LoginDenied
    Created on : 2018/07/30, 17:01:31
    Author     : guest1Day
--%>
<%@page import="beans.gototop"%>

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
        <a href="ud_Login.jsp">ログイン画面に戻る</a>
    </body>
    <br>
        <%=gototop.getInstance().home()%>
</html>
