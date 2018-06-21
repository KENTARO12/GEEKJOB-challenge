<%-- 
    Document   : intro
    Created on : 2018/06/21, 16:54:22
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>from html</title>
    </head>
    <body>

<% 
request.setCharacterEncoding("utf-8");
out.println(request.getParameter("name"));
out.println("<br>");
if(request.getParameter("gender1")!=null){
    out.println(request.getParameter("gender1"));
}else{
    out.println(request.getParameter("gender2"));
}
out.println("<br>");
out.println(request.getParameter("hobby"));
%>
    </body>
</html>
