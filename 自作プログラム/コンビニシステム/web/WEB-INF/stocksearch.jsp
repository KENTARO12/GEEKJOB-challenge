<%-- 
    Document   : stocksearch
    Created on : 2018/08/10, 15:18:38
    Author     : guest1Day
--%>

<%@page import="beans.item"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品検索</title>
    </head>
    <body>
        <form action="stocksearch_result" method="GET">
            <input required type="text" name="item" placeholder="名前かJANコード"><br>
            <input type="submit" name="do" value="検索"><br><br>
        </form>
            <a href="top.jsp">トップへ戻る</a>
    </body>
</html>
