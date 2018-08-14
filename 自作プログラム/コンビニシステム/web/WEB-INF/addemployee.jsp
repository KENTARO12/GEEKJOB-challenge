<%-- 
    Document   : addemployee
    Created on : 2018/08/14, 19:58:12
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>従業員登録</title>
    </head>
    <body>
        <form action="addemployee_confirm" method="GET">
            名前：<input required type="text" name="name" placeholder="名前"><br>
            パスワード：<input type="text" name="pass" placeholder="パスワード"><br>
            <input type="submit" name="do" value="登録"><br>
        </form>
    </body>
    <br><br>
    <a href="top.jsp">トップへ戻る</a>
</html>
