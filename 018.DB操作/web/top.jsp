<%-- 
    Document   : login_out
    Created on : 2018/08/02, 13:27:29
    Author     : guest1Day
--%>
<%
    HttpSession hs = request.getSession();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>トップ画面</title>
    </head>
    <body>
        <%if(hs.getAttribute("user")==null){%>
            <form action="login1" method="POST">
                名前：<input type="text" name="name"><br>
                パスワード：<input type="text" name="pass"><br><br>
                <input type="submit" value="ログイン">
            </form>
        <%}else{
            String name = (String)hs.getAttribute("user");%>
        [<%=name%>]さんのアカウントでログインしています<br><br>
            <a href="edit.jsp">商品情報の追加</a><br>
            <a href="list1">商品情報の確認</a><br><br>
            <a href="logout1">ログアウト</a>
        <%}%>
    </body>
</html>