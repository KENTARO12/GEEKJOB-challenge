<%-- 
    Document   : top
    Created on : 2018/08/03, 10:48:01
    Author     : guest1Day
--%>
<%@page import="org.camp.userbean"%>
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
        <form action="getSession" method="GET">
            <%if(hs.getAttribute("user")==null){%>
                名前：<input required type="text" name="name" value=""><br>
                性別<br>
                男性：<input required type="radio" name="gender" value="1"><br>
                女性：<input required type="radio" name="gender" value="2"><br>
                趣味：<input type="text" name="hobby" value=""><br>
            <%}else{
                userbean user = (userbean)hs.getAttribute("user");%>
                名前：<input required type="text" name="name" value="<%=user.getName()%>"><br>
                性別<br>
                <%if(user.getGender()==1){%>
                男性：<input required type="radio" name="gender" value="1" checked><br>
                女性：<input required type="radio" name="gender" value="2"><br>
                <%}else{%>
                男性：<input required type="radio" name="gender" value="1"><br>
                女性：<input required type="radio" name="gender" value="2"checked><br>
                <%}%>
                趣味：<input type="text" name="hobby" value="<%=user.getHobby()%>"><br>
            <%}%>
            <input type="submit" name="do" value="送信">
        </form>
    </body>
</html>
