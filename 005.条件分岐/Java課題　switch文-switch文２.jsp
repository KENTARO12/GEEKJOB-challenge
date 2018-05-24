<%-- 
    Document   : newjsp
    Created on : 2018/05/24, 17:34:12
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    char letter='お';
        switch(letter){
            case 'A':
                out.print("英語");
                break;
            case 'あ':
                out.print("日本語");
                break;                
        }
    
%>