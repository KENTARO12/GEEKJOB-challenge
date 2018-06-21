<%-- 
    Document   : newjsp1
    Created on : 2018/06/21, 14:38:19
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>自己紹介</title>
    </head>
    <body>
        <form action="intro.jsp" method="post">
            名前：<input type="text" name = "name"><br><br>
            男<input type="radio" name="gender1" value="男">
            女<input type="radio" name="gender2" value="女"><br><br>
            趣味：<textarea name="hobby"></textarea><br><br>
            <input type="submit" value="send">
        </form>
    </body>
</html>