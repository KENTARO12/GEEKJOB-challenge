<%-- 
    Document   : newjsp
    Created on : 2018/05/25, 15:37:49
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    float num=1000;
    while(num>=100){
        num=num/2;
    }
    out.print(num);
%>