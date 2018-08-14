<%-- 
    Document   : stockedit_search
    Created on : 2018/08/13, 15:01:00
    Author     : guest1Day
--%>
<%@page import="beans.item"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%
    HttpSession hs = request.getSession();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品検索</title>
    </head>
    <body>
        <%if(request.getAttribute("deleted")!=null){
            String name = (String)request.getAttribute("deleted");%>
            <%=name%>の商品登録を削除しました。
        <%  hs.removeAttribute("delete");
        }%>
        <%if(hs.getAttribute("change")!=null){
            item changingitem = (item)hs.getAttribute("change");%>
            <h3><%=changingitem.getName()%>の商品情報を更新しました。</h3>
        <%  hs.removeAttribute("change");
        }%>
        <form action="stockedit_list" method="GET">
            <input type="text" name="item" placeholder="名前かJANコード"><br>
            <input type="submit" name="do" value="検索"><br><br>
        </form>
        <a href="top.jsp">トップへ戻る</a>
    </body>
</html>
