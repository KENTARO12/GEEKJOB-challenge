<%-- 
    Document   : newjsp
    Created on : 2018/05/25, 14:16:22
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String letter="";
    for(int i=0;i<30;i++){
        letter=letter+"A";
    }
    out.print(letter);
%>