<%-- 
    Document   : newjsp
    Created on : 2018/05/25, 12:00:13
    Author     : guest1Day
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ArrayList<String> figs = new ArrayList<String>();
        figs.add("10");
        figs.add("100");
        figs.add("soeda");
        figs.add("hayashi");
        figs.add("-20");
        figs.add("118");
        figs.add("END");
        
        out.print(figs.get(0)+"<br>");
        out.print(figs.get(1)+"<br>");
        out.print(figs.get(2)+"<br>");
        out.print(figs.get(3)+"<br>");
        out.print(figs.get(4)+"<br>");
        out.print(figs.get(5)+"<br>");
        out.print(figs.get(6)+"<br>");
%>