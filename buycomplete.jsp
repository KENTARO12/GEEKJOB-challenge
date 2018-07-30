<%-- 
    Document   : buycomplete
    Created on : 2018/07/29, 18:37:19
    Author     : user
--%>
<%@page import="beans.user"%>
<%@page import="beans.gototop"%>
<%
    gototop gto = gototop.getInstance();
    HttpSession hs = request.getSession();
    user ud = (user)hs.getAttribute("loginUser");
    int userID=ud.getUserID();
    String strID = String.valueOf(userID);
    String str = (String)request.getAttribute("type");
    int total = (Integer)request.getAttribute("total");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>購入完了</title>
    </head>
    <body>
        <h2>お買い上げありがとうございます。<br>
        総額：<%=total%>円<br>
        発送方法：<%=str%><br>
        以上の内容で承りました。    
        <br><br><br><br>
        嘘です。お金はいただきませんが、発送もいたしません。
        </h2>
        <h5><%=gototop.getInstance().home()%></h5>
<%
    hs.removeAttribute("cart"+strID);
    hs.removeAttribute("staff");
    hs.removeAttribute("link");
    hs.removeAttribute("id");
%>
    </body>
</html>
