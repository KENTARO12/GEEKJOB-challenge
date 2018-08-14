<%-- 
    Document   : stockinput_search
    Created on : 2018/08/13, 11:37:41
    Author     : guest1Day
--%>
<%@page import="beans.item"%>
<%@page import="javax.servlet.http.HttpSession"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品検索</title>
    </head>
    <body>
        <%if(request.getAttribute("input")!=null){
            item item1 = (item)request.getAttribute("input");%>
            <%=item1.getName()%>を<%=item1.getNumber()%>個、売り上げ入力しました。<br><br>
        <%}%>
        <form action="stockinput_list" method="GET">
            <input type="text" name="item" placeholder="名前かJANコード"><br>
            <input type="submit" name="do" value="検索"><br><br>
        </form>
        <a href="top.jsp">トップへ戻る</a>
    </body>
</html>
