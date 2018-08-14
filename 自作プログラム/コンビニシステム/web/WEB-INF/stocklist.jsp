<%-- 
    Document   : stocklist
    Created on : 2018/08/06, 11:20:22
    Author     : guest1Day
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.item"%>
<%
    HttpSession hs = request.getSession();
    ArrayList<item> array = (ArrayList)hs.getAttribute("stock");
    item anitem = new item();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫一覧</title>
    </head>
    <body>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>値段(円)</th>
                <th>種別</th>
                <th>商品コード</th>
                <th>在庫数</th>
                <th>最終取扱日</th>
                <th>場所</th>
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
                <td><%= anitem.getPlace()%></td>
            </tr>
            <%}%>
        </table>
        
        <a href="top.jsp">トップへ戻る</a>
    </body>
</html>
