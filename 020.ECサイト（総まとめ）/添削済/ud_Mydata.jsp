<%-- 
    Document   : ud_Mydata
    Created on : 2018/07/30, 17:00:49
    Author     : guest1Day
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="beans.gototop"
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
        <title>アカウント情報</title>
    </head>
    <body>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String strDate = sdf.format(ud.getNewDate());
%>
    <h3>アカウント情報</h3><%--<a href="ResultDetail?id=<%= ud.getUserID()%>"><%=ud.getAddress()%></a>のようにもできる--%>
        名前：<%= ud.getName()%><br>
        パスワード：<%=ud.getPassword()%><br>
        メールアドレス：<%=ud.getMail()%><br>
        お届け先住所：<%=ud.getAddress()%><br>
        総購入金額：<%=ud.getTotal()%><br>
        アカウント更新日：<%=strDate%><br><br><br>
            
        <a href="UD_History?id=<%= ud.getUserID()%>">購入履歴</a><br><br>
        <a href="ud_Update.jsp">登録情報の変更</a><br><br>
        <a href="ud_Delete.jsp?id=<%= ud.getUserID()%>">登録情報の削除</a><br>
            
    </body>
    <br>
    <h5><%=gototop.getInstance().home()%></h5>
</html>
