<%-- 
    Document   : employeeInfo_edit
    Created on : 2018/08/15, 0:26:21
    Author     : guest1Day
--%>
<%@page import="beans.userdata"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.item"%>
<%
    HttpSession hs = request.getSession();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%if(hs.getAttribute("selectedEmployee")!=null){
    int flag = (Integer)request.getAttribute("flag");
    userdata employee = (userdata)hs.getAttribute("selectedEmployee");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>従業員情報の編集</title>
    </head>
    <body>
        対象従業員：名前:<%=employee.getName()%>/従業員ID:<%=employee.getID()%>
        <form action="employeeInfo_edit_confirm" method="GET">
        <%switch(flag){
            case 1:%>
                <h3>名前の変更</h3>
                <%=employee.getName()%>
                <br>　↓<br>
                <input type="text" name="name">
                <%break;
            case 2:%>
                <h3>IDの変更</h3>
                <%=employee.getID()%>
                <br>　↓<br>
                <input type="int" name="id">
                <%break;
            case 3:%>
                <h3>パスワードの変更</h3>
                <%=employee.getPassword()%>
                <br>　↓<br>
                <input type="text" name="pass">
                <%break;
            case 4:%>
                <h3>ステータスの変更</h3>
                <%=employee.getStatus()%>
                <br>　↓<br>
                <input type="int" name="status">
                <%break;
        }%>
            <br>    
            <input type="submit" name="do" value="更新">
        </form>
    </body>
    

<%}else{
    userdata employee = (userdata)hs.getAttribute("delete");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録消去</title>
    </head>
    <body>
        <h2>以下の従業員の情報を消去しますか？</h2>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>従業員ID</th>
                <th>パスワード</th>
                <th>ステータス</th>
            </tr>
            <tr>
                <td><%= employee.getName()%></td>
                <td><%= employee.getID()%></td>
                <td><%= employee.getPassword()%></td>
                <td><%= employee.getStatus()%></td>
            </tr>    
        </table>
        <br>
        <form action="employeeInfo_delete" method="GET">
            <input type="submit" name="delete" value="消去">
        </form>
        <br>
    </body>
    <%}%>
    
    <br><br>
    <a href="top.jsp">トップへ戻る</a>
</html>
