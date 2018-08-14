<%-- 
    Document   : stockedit_list
    Created on : 2018/08/13, 15:05:33
    Author     : guest1Day
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.item"%>
<%
    HttpSession hs = request.getSession();
    ArrayList<item> shelf = (ArrayList)hs.getAttribute("stockedit_list");
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
        <%if(hs.getAttribute("delete")!=null){
            hs.removeAttribute("delete");%>
            <h3>在庫数が０個でないため、登録消去ができません。</h3>
        <%}%>
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
                <td><a href="MoveToStockeditJSP?id=<%=i%>&class=1"><%= item1.getName()%></a></td>
                <td><a href="MoveToStockeditJSP?id=<%=i%>&class=2"><%= item1.getPrice()%></a></td>
                <%switch(item1.getType()){
                    case 1:%>
                        <td><a href="MoveToStockeditJSP?id=<%=i%>&class=3">食品</a></td>
                        <%break;
                    case 2:%>
                        <td><a href="MoveToStockeditJSP?id=<%=i%>&class=3">清涼飲料水</a></td>
                        <%break;
                    case 3:%>
                        <td><a href="MoveToStockeditJSP?id=<%=i%>&class=3">雑貨</a></td>
                        <%break;
                    case 4:%>
                        <td><a href="MoveToStockeditJSP?id=<%=i%>&class=3">雑誌</a></td>
                        <%break;
                    case 5:%>
                        <td><a href="MoveToStockeditJSP?id=<%=i%>&class=3">タバコ</a></td>
                        <%break;
                    case 6:%>
                        <td><a href="MoveToStockeditJSP?id=<%=i%>&class=3">酒</a></td>
                        <%break;
                    case 7:%>
                        <td><a href="MoveToStockeditJSP?id=<%=i%>&class=3">金券</a></td>
                        <%break;
                    default:%>
                        <td><a href="MoveToStockeditJSP?id=<%=i%>&class=3">その他</a></td>
                        <%break;
                }%>
                <td><a href="MoveToStockeditJSP?id=<%=i%>&class=4"><%= item1.getCode()%></a></td>
                <td><a href="MoveToStockeditJSP?id=<%=i%>&class=5"><%= item1.getNumber()%></a></td>
                <td><%= item1.getDate()%></td>
                <td><a href="MoveToStockeditJSP?id=<%=i%>&class=6"><%= item1.getPlace()%></a></td>
                <td><form action="MoveToStockeditJSP" method="GET">
                        <input type="hidden" name="shelfnum" value="<%=i%>">
                        <input type="submit" name="delete" value="登録削除">
                    </form>
                </td>
            </tr>
            <%}%>
        </table>
        <a href="top.jsp">トップへ戻る</a>
    </body>
</html>

