<%-- 
    Document   : newjsp
    Created on : 2018/05/24, 13:50:18
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int num = 1;
    
        if(num==1){
            out.print("１です！");
        }else if(num==2){
            out.print("プログラミングキャンプ！");
        }else{
            out.print("その他です！");
        }
%>