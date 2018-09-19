<%-- 
    Document   : ud_Delete
    Created on : 2018/09/15, 9:48:54
    Author     : guest1Day
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="beans.gototop"
        import="beans.user"%>
<%
    HttpSession hs = request.getSession();
    user ud = (user)hs.getAttribute("loginUser");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String strDate = sdf.format(ud.getNewDate());
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>アカウント情報の削除</title>
    </head>
    <body>
        <h3>現在ログインしている、以下のアカウント情報を削除します。<br>
        よろしいですか？<br></h3>
        
        アカウント情報
        名前：<%= ud.getName()%><br>
        パスワード：<%=ud.getPassword()%><br>
        メールアドレス：<%=ud.getMail()%><br>
        お届け先住所：<%=ud.getAddress()%><br>
        総購入金額：<%=ud.getTotal()%><br>
        アカウント更新日：<%=strDate%><br><br><br>
        
        <a href="UD_DeleteComplete?id=<%=ud.getUserID()%>">削除する</a><br>
    </body>
    <br>
    <h5><%=gototop.getInstance().home()%></h5>
</html>
