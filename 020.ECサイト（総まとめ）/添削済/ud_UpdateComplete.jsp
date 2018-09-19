<%-- 
    Document   : ud_UpdateComplete
    Created on : 2018/07/30, 16:57:05
    Author     : guest1Day
--%>
<%@page import="beans.gototop"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>更新完了</title>
    </head>
    <body>
        <h3>データの更新が正常に完了しました。</h3>
    </body>
    <h5><br><a href="ud_Mydata.jsp">アカウント情報へ戻る</a></h5>
    <h5><%=gototop.getInstance().home()%></h5>
</html>
