<%-- 
    Document   : edit
    Created on : 2018/08/02, 13:56:06
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品情報の登録</title>
    </head>
    <body>
        <form action="editconfirm1" method="POST">
                名前：<input required type="text" name="name"><br>
                値段：<input required type="number" name="price"><br>
                個数：<input required type="number" name="num"><br><br>
                <input type="submit" value="登録">
        </form>
    </body>
</html>
