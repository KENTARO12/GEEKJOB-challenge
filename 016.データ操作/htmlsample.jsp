<%-- 
    Document   : htmlsample
    Created on : 2018/08/03, 10:09:33
    Author     : guest1Day
--%>
<%@page import="java.util.ArrayList"%>
<%-- 
    tableタグの利用とhrefタグからの値の受け渡し
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%//このarraylistはほかのページから受取ったものであることを想定しています。
    ArrayList<Integer> array = new ArrayList<Integer>();
    for(int i = 1;i<10;i++){
        array.add(i);
    }
%>
        <table border=1>
            <tr>
                <th>一倍</th>
                <th>七倍</th>
            </tr>
            <tr>
            <%for(int j = 0;j<array.size();j++){%>
            <td><a href="empty?id=<%=j%>"><%= array.get(j)%></a></td><%--empty.javaは作ってません--%>
                <td><%= (array.get(j))*7%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
