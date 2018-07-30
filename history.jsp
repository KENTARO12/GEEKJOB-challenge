<%-- 
    Document   : history
    Created on : 2018/07/30, 15:49:18
    Author     : guest1Day
--%>
<%@page import="beans.historybean"%>
<%@page import="java.util.ArrayList"%>
<%-- 
    名前、値段、購入年月日を表示。
--%>
<%@page import="beans.user"%>
<%@page import="beans.gototop"%>
<%
    HttpSession hs = request.getSession();
    gototop gto = gototop.getInstance();
    ArrayList array = (ArrayList)hs.getAttribute("history");
    historybean history = new historybean();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>購入履歴</title>
    </head>
    <body>

        <table border=1>
            <tr>
                <th>名前</th>
                <th>値段(円)</th>
                <th>購入日</th>
            </tr>
            <tr>
                <%for(int i = 0;i<array.size();i++){
                    history = (historybean)array.get(i);%>
                <td><%= history.getName()%></td>
                <td><%= history.getPrice()%></td>
                <td><%= history.getBuyDate()%></td>
            </tr>
            <%}%>
        </table>
    </body>
    <br><br>
    <h5><%=gototop.getInstance().home()%></h5>
</html>
