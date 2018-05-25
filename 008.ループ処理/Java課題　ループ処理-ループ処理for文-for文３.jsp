<%-- 
    Document   : newjsp
    Created on : 2018/05/25, 14:49:03
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int num=0;
    for(int i=0;i<=100;i++){
        num=num+i;
    }
    out.print(num);
%>