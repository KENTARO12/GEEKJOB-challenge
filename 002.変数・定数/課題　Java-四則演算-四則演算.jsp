<%-- 
    Document   : 課題　Java-四則演算-四則演算
    Created on : 2018/05/24, 11:41:18
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   final int BASE =144;
   int num =12;
    
    int tashizan = BASE + num;
    out.print(tashizan);
    
    int hikizan = BASE - num;
    out.print(hikizan);
    
    int kakezan= BASE * num;
    out.print(kakezan);
    
    int warizan= BASE / num;
    out.print(warizan);
    
    int jouyozan= BASE % num;
    out.print(jouyozan);
    
%>
    