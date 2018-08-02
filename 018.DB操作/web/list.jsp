<%-- 
    Document   : list
    Created on : 2018/08/02, 13:55:23
    Author     : guest1Day
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.itemBean"%>
<%
    ArrayList array = (ArrayList)request.getAttribute("item");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫一覧</title>
    </head>
    <body>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>値段(円)</th>
                <th>個数</th>
            </tr>
            <tr>
                <%for(int i = 0;i<array.size();i++){
                    itemBean item = (itemBean)array.get(i);%>
                <td><%= item.getName()%></td>
                <td><%= item.getPrice()%></td>
                <td><%= item.getNumber()%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
