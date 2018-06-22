<%-- 
    Document   : query_string_input
    Created on : 2018/06/22, 10:26:49
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>クエリストリング　入力画面</title>
    </head>
    <body>
        <form action="query_string_output.jsp" method="GET">
            総額：<input type="text" name="total"><br><br>
            数量：<input type="text" name="count"><br><br>
            種類：　雑貨<input type="radio" name="type" value="雑貨">
            生鮮食品<input type="radio" name="type" value="生鮮食品">
            その他<input type="radio" name="type" value="その他"><br><br>
            <input type="submit" value="送信">
        </form>
    </body>
</html>
