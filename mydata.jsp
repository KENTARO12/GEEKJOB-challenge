<%-- 
    Document   : mydata
    Created on : 2018/07/20, 16:31:37
    Author     : guest1Day
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="beans.gototop"
        import="beans.user"%>
<%
    HttpSession hs = request.getSession();
    gototop gto = gototop.getInstance();
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
      名前：<a href="update.jsp?id=1"><%= ud.getName()%></a><br>
            パスワード：<a href="update.jsp?id=2"><%=ud.getPassword()%></a><br>
            メールアドレス：<a href="update.jsp?id=3"><%=ud.getMail()%></a><br>
            お届け先住所：<a href="update.jsp?id=4"><%=ud.getAddress()%></a><br>
            総購入金額：<%=ud.getTotal()%><br>
            アカウント更新日：<%=strDate%><br><br>
            
            <a href="history?id=<%= ud.getUserID()%>">購入履歴</a><br>
            
    </body>
    <br><br>
    <h5><%=gototop.getInstance().home()%></h5>
</html>
