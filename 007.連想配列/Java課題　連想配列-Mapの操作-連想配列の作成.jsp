<%-- 
    Document   : newjsp1
    Created on : 2018/05/25, 13:31:47
    Author     : guest1Day
--%>

<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HashMap<String,String> sample = new HashMap<String,String>();
    
    sample.put("1","AAA");
    sample.put("hello","world");
    sample.put("soeda","33");
    sample.put("20","20");
    

      out.print(sample.get("1"));
    
%>