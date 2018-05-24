<%-- 
    Document   : newjsp
    Created on : 2018/05/24, 11:53:02
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   final int BASE =145;
   int num =12;
   //tashizan
   out.print(BASE+num);
   
   //hikizan
   out.print(BASE-num);
   
   //kakezan
   out.print(BASE*num);
   
   //warizan
   out.print(BASE/num);
   
   //jouyozan
   out.print(BASE%num);
%>