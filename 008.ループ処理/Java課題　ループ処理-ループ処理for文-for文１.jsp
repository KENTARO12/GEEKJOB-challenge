<%-- 
    Document   : newjsp
    Created on : 2018/05/25, 14:36:52
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    long num=1;
    for(int i=0;i<20;i++){
        num=num*8;
    }
    out.print(num);
%>