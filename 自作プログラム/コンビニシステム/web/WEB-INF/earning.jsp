<%-- 
    Document   : earning
    Created on : 2018/08/13, 11:07:33
    Author     : guest1Day
--%>
<%@page import="beans.earningTotal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.item"%>
<%@page import="beans.returnNowDate"%>
<%
    String searchDate = (String)request.getAttribute("searchingDate");
    HttpSession hs = request.getSession();
    ArrayList<item> array = (ArrayList)hs.getAttribute("earningDetail");
    earningTotal total = (earningTotal)hs.getAttribute("earningNumber");
    item anitem = new item();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>売り上げ確認</title>
    </head>
    <body>
        <h2>対象営業日：<%=searchDate%></h2>
        <h1>売上総額：<%=total.getTotal()%>円</h1>
        
        <h2>種別売り上げ</h2>
        食品：<%=total.getType1()%>円<br>
        清涼飲料水：<%=total.getType2()%>円<br>
        雑貨：<%=total.getType3()%>円<br>
        雑誌：<%=total.getType4()%>円<br>
        タバコ：<%=total.getType5()%>円<br>
        酒類：<%=total.getType6()%>円<br>
        金券：<%=total.getType7()%>円
        <br><br><br>
        
        売り上げ詳細：
        <table border=1>
            <tr>
                <th>名前</th>
                <th>値段(円)</th>
                <th>種別</th>
                <th>商品コード</th>
                <th>売り上げ数</th>
                <th>取引時間</th>
            </tr>
            
            <tr>
            <%for(int i = 0;i<array.size();i++){
                    anitem = (item)array.get(i);%>
                <td><%= anitem.getName()%></td>
                <td><%= anitem.getPrice()%></td>
                <%switch(anitem.getType()){
                    case 1:%>
                        <td>食品</td>
                        <%break;
                    case 2:%>
                        <td>清涼飲料水</td>
                        <%break;
                    case 3:%>
                        <td>雑貨</td>
                        <%break;
                    case 4:%>
                        <td>雑誌</td>
                        <%break;
                    case 5:%>
                        <td>タバコ</td>
                        <%break;
                    case 6:%>
                        <td>酒</td>
                        <%break;
                    case 7:%>
                        <td>金券</td>
                        <%break;
                    default:%>
                        <td>その他</td>
                        <%break;
                }%>
                <td><%= anitem.getCode()%></td>
                <td><%= anitem.getNumber()%></td>
                <td><%= anitem.getDate()%></td>
            </tr>
            <%}%>
        </table>
        
        <a href="top.jsp">トップへ戻る</a>
    </body>
</html>
