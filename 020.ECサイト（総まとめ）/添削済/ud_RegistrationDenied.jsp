<%-- 
    Document   : ud_RegistrationDenied
    Created on : 2018/09/15, 12:39:42
    Author     : guest1Day
--%>

<%@page import="beans.gototop"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規登録エラー</title>
    </head>
    <body>
        <h2>すでに同じ名前、パスワードの組み合わせを使っているアカウントがあります。<br>
        異なる名前、またはパスワードをご利用ください。</h2>
        <a href="ud_Registration.jsp">新規登録画面へ戻る</a><br><br>
        <%=gototop.getInstance().home()%>
    </body>
</html>
