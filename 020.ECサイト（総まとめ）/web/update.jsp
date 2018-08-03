<%-- 
    Document   : updateName
    Created on : 2018/07/23, 17:22:00
    Author     : guest1Day
--%>
<%@page import="java.text.SimpleDateFormat"
        import="beans.gototop"
        import="beans.user"%>
<%
    HttpSession hs = request.getSession();
    gototop gto = gototop.getInstance();
    user ud = (user)hs.getAttribute("loginUser");
    int id = Integer.parseInt(request.getParameter("id"));
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>アカウント情報の更新</title>
    </head>
    <body>
        <%if(id==1){%>
        名前：<%= ud.getName()%><br>
        　　↓
        <form action="updatecomplete" method="POST">
            <input required type="text" name="name" value="">
            <input type="hidden" name="id2" value="1">
            <input type="submit" name="btnSubmit" value="更新">
        </form>
        <%}else if(id==2){%>
        パスワード：<%= ud.getPassword()%><br>
        　　↓
        <form action="updatecomplete" method="POST">
            <input required type="text" name="pass" value="">
            <input type="hidden" name="id2" value="2">
            <input type="submit" name="btnSubmit" value="更新">
        </form>
        <%}else if(id==3){%>
        メールアドレス：<%= ud.getMail()%><br>
        　　↓
        <form action="updatecomplete" method="POST">
            <input required type="text" name="mail" value="">
            <input type="hidden" name="id2" value="3">
            <input type="submit" name="btnSubmit" value="更新">
        </form>
        <%}else if(id==4){%>
        お届け先住所：<%= ud.getAddress()%><br>
        　　↓
        <form action="updatecomplete" method="POST">
            <input required type="text" name="address" value="">
            <input type="hidden" name="id2" value="4">
            <input type="submit" name="btnSubmit" value="更新">
        </form>
        <%}%>
    </body>
    <br><br>
    <h5><%=gototop.getInstance().home()%></h5>
</html>
