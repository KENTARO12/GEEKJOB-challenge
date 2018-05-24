<%-- 
    Document   : newjsp
    Created on : 2018/05/24, 14:45:55
    Author     : guest1Day
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int num = 1;
switch(num){
    case 1:
        out.print("one");
        break;
    case 2:
        out.print("two");
        break;
    default:
        out.print("想定外");
        break;
}
%>