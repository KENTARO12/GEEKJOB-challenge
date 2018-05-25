<%-- 
    Document   : for 1
    Created on : 2018/05/25, 13:56:24
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    long result=1;
    for(int i=0;i<20;i++){
        result=result*8;
    }
    out.print(result);
%>