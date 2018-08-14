<%-- 
    Document   : stocksearch_result
    Created on : 2018/08/10, 15:31:38
    Author     : guest1Day
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="beans.item"%>
<%
    HttpSession hs = request.getSession();
    ArrayList<item> shelf = (ArrayList)hs.getAttribute("searchresult");
    item item1 = new item();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索結果</title>
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
            <%for(int i = 0;i<shelf.size();i++){
                    item1 = (item)shelf.get(i);%>
                <td><%= item1.getName()%></td>
                <td><%= item1.getPrice()%></td>
                <%switch(item1.getType()){
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
                <td><%= item1.getCode()%></td>
                <td><%= item1.getNumber()%></td>
                <td><%= item1.getDate()%></td>
                <td><%= item1.getPlace()%></td>
                
            </tr>
            <%}%>
        </table>
        <a href="top.jsp">トップへ戻る</a>
    </body>
</html>
