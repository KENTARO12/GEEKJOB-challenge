<%-- 
    Document   : stockedit
    Created on : 2018/08/13, 15:21:23
    Author     : guest1Day
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.item"%>
<%
    HttpSession hs = request.getSession();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%if(hs.getAttribute("change")!=null){
    int clas = (Integer)request.getAttribute("class");
    item item1 = (item)hs.getAttribute("change");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫編集</title>
    </head>
    <body>
        <form action="stockedit_confirm" method="GET">
        <%switch(clas){
            case 1:%>
                <h3>名前の変更</h3>
                <%=item1.getName()%>
                <br>　　　　↓<br>
                <input type="text" name="name">
                <%break;
            case 2:%>
                <h3>値段の変更</h3>
                <%=item1.getPrice()%>円
                <br>　　　　↓<br>
                <input type="int" name="price">
                <%break;
            case 3:%>
                <h3>種別の変更</h3>
                <%=item1.getType()%>
                <br>　　　　↓<br>
                <input type="int" name="type">
                <%break;
            case 4:%>
                <h3>コードの変更</h3>
                <%=item1.getCode()%>
                <br>　　　　↓<br>
                <input type="text" name="code">
                <%break;
            case 5:%>
                <h3>在庫数の変更</h3>
                <%=item1.getNumber()%>個
                <br>　　　　↓<br>
                <input type="int" name="number">
                <%break;
            case 6:%>
                <h3>場所の変更</h3>
                <%=item1.getPlace()%>
                <br>　　　　↓<br>
                <input type="text" name="place">
                <%break;
        }%>
            <br>    
            <input type="submit" name="do" value="更新">
        </form>
    </body>
    

<%}else{
    item item2 = (item)hs.getAttribute("delete");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録消去</title>
    </head>
    <body>
        <h2>以下の商品の登録を消去しますか？</h2>
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
                <td><%= item2.getName()%></td>
                <td><%= item2.getPrice()%></td>
                <%switch(item2.getType()){
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
                <td><%= item2.getCode()%></td>
                <td><%= item2.getNumber()%></td>
                <td><%= item2.getDate()%></td>
                <td><%= item2.getPlace()%></td>
            </tr>    
        </table>
        <br>
        <form action="stockedit_delete" method="GET">
            <input type="submit" name="delete" value="消去">
        </form>
        <br>
    </body>
    <%}%>
    
    <br><br>
    <a href="top.jsp">トップへ戻る</a>
</html>