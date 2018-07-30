<%-- 
    Document   : error
    Created on : 2018/07/20, 14:06:37
    Author     : guest1Day
--%>
<%@page import="beans.gototop" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>error</title>
    </head>
    <body>
        エラーが発生しました。以下の項目を確認してください。<br>
        <%=request.getAttribute("error")%><br><br>
        <%=gototop.getInstance().home()%>
    </body>
</html>
