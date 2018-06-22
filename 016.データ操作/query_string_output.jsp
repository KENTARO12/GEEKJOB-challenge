<%-- 
    Document   : query_string_output
    Created on : 2018/06/22, 10:30:12
    Author     : guest1Day
--%>


<%@page import="java.lang.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>クエリストリング　出力画面</title>
    </head>
    <body>
<%
    request.setCharacterEncoding("utf-8");
    out.print(request.getParameter("type")+"が");
    out.print(request.getParameter("count")+"個あり、");
    out.println("総額は"+request.getParameter("total")+"円です。<br>");
    
    String TOTAL = request.getParameter("total");
    String COUNT = request.getParameter("count");
    int intTOTAL;
    int intCOUNT;
    
    intTOTAL = Integer.parseInt(TOTAL);
    intCOUNT = Integer.parseInt(COUNT);
    
    
    int unit = intTOTAL/intCOUNT;
    out.println("単価は"+unit+"円です。<br>");
    
    double point;
    if(intTOTAL<3000){
        point=0;
    }else if(5000<=intTOTAL){
        point=0.05;
    }else{
        point=0.04;
    }
    double point1 =intTOTAL*point;
    int point2 = (int)point1;
    out.println("今回付与されるポイントは"+point2+"Pです。");

/*
    商品購入総額に応じてポイントを計算し，その値が画面に表示される
　※ポイントは商品購入総額を基準にして，以下の様に算出する 
　　3000 円未満 ... 0% 
　　3000 円以上で5000円未満 ... 購入総額の 4% 
　　5000 円以上 ... 購入総額の 5%*/

%>
    </body>
</html>
