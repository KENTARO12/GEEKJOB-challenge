<%-- 
    Document   : ud_Update
    Created on : 2018/07/30, 17:03:22
    Author     : guest1Day
--%>
<%@page import="java.text.SimpleDateFormat"
        import="beans.gototop"
        import="beans.user"%>
<%
    HttpSession hs = request.getSession();
    user ud = (user)hs.getAttribute("loginUser");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>アカウント情報の更新</title>
    </head>
    <body>
        <form action="UD_UpdateComplete" method="POST">
            名前：<input required type="text" name="name" value="<%=ud.getName()%>"><br>
            パスワード：<input required type="text" name="pass" value="<%=ud.getPassword()%>"><br>
            メールアドレス：<input required type="text" name="mail" value="<%=ud.getMail()%>"><br>
            お届け先住所：<input required type="text" name="address" value="<%=ud.getAddress()%>"><br><br>
            <input type="submit" name="btnSubmit" value="更新">
        </form>
    </body>
    <br><br>
    <h5><%=gototop.getInstance().home()%></h5>
</html>
