<%-- 
    Document   : employee
    Created on : 2018/08/14, 23:06:26
    Author     : guest1Day
--%>

<%@page import="beans.userdata"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>従業員の追加、編集</title>
    </head>
    <body>
        <%if(request.getAttribute("newEmployee")!=null){
            userdata newEmployee = (userdata)request.getAttribute("newEmployee");%>
            新規従業員：名前:<%=newEmployee.getName()%>/従業員ID:<%=newEmployee.getID()%>/パスワード:<%=newEmployee.getPassword()%>
            上記の情報を登録しました。<br><br>
        <%}else if(request.getAttribute("edittingEmployee")!=null){
            userdata edittingEmployee = (userdata)request.getAttribute("edittingEmployee");%>
            新規従業員：名前:<%=edittingEmployee.getName()%>/従業員ID:<%=edittingEmployee.getID()%>/パスワード:<%=edittingEmployee.getPassword()%>/ステータス:<%=edittingEmployee.getStatus()%>
            上記の情報を更新しました。<br><br>
        <%}else if(request.getAttribute("deletedEmployee")!=null){
            userdata deletedEmployee = (userdata)request.getAttribute("deletedEmployee");%>
            新規従業員：名前:<%=deletedEmployee.getName()%>/従業員ID:<%=deletedEmployee.getID()%>/パスワード:<%=deletedEmployee.getPassword()%>/ステータス:<%=deletedEmployee.getStatus()%>
            上記の情報を更新しました。<br><br>
        <%}%>
        <a href="MoveToAddemployeeJSP">従業員データの追加</a><br><br>
        <a href="MoveToEmployeeInfo_searchJSP">従業員データの確認、編集</a><br><br><br>
    </body>
    <a href="top.jsp">トップへ戻る</a>
</html>
