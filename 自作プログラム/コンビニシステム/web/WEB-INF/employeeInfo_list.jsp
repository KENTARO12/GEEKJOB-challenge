<%-- 
    Document   : showEmployee
    Created on : 2018/08/14, 23:42:06
    Author     : guest1Day
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.userdata"%>
<%
    HttpSession hs = request.getSession();
    ArrayList<userdata> roster = (ArrayList)hs.getAttribute("roster");
    userdata employee = new userdata();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索結果</title>
    </head>
    <body>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>ID</th>
                <th>パスワード</th>
                <th>ステータス</th>
            </tr>
            <tr>
            <%for(int i = 0;i<roster.size();i++){
                    employee = (userdata)roster.get(i);%>
                <td><a href="employeeInfo_edit?id=<%=i%>&flag=1"><%= employee.getName()%></a></td>
                <td><a href="employeeInfo_edit?id=<%=i%>&flag=2"><%= employee.getID()%></a></td>
                <td><a href="employeeInfo_edit?id=<%=i%>&flag=3"><%= employee.getPassword()%></a></td>
                <td><a href="employeeInfo_edit?id=<%=i%>&flag=4"><%= employee.getStatus()%></a></td>
                <td><form action="employeeInfo_edit" method="GET">
                        <input type="hidden" name="rosterNum" value="<%=i%>">
                        <input type="submit" name="delete" value="登録削除">
                    </form>
                </td>
            </tr>
            <%}%>
        </table>
        <a href="top.jsp">トップへ戻る</a>
    </body>
</html>


