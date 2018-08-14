<%-- 
    Document   : employeeInfo_search
    Created on : 2018/08/15, 0:03:14
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>従業員検索</title>
    </head>
    <body>
        <form action="employeeInfo_list" method="GET">
            <input type="text" name="nameORid" placeholder="名前か従業員ID"><br>
            <input type="submit" name="do" value="検索"><br><br>
        </form>
        <a href="top.jsp">トップへ戻る</a>
    </body>
</html>
