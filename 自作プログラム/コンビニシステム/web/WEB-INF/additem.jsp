<%-- 
    Document   : additem
    Created on : 2018/08/14, 19:58:12
    Author     : guest1Day
--%>

<%@page import="beans.item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品登録</title>
    </head>
    <body>
        <%if(request.getAttribute("addingitem")!=null){
            item additem = (item)request.getAttribute("addingitem");%>
            新商品：<%=additem.getName()%>/<%=additem.getPrice()%>/<%=additem.getType()%>/<%=additem.getCode()%>/<%=additem.getNumber()%>/<%=additem.getPlace()%><br>
            以上の商品を登録しました。<br>
        <%}%>
        <form action="additem_confirm" method="GET">
            名前：<input required type="text" name="name" placeholder="名前"><br>
            値段：<input required type="int" name="price" placeholder="値段"><br>
            種別：<input required type="int" name="type" placeholder="種別"><br>
            コード:<input required type="text" name="code" placeholder="商品コード"><br>
            数量：<input required type="int" name="number" placeholder="数量"><br>
            場所：<input required type="text" name="place" placeholder="場所"><br>
            <input type="submit" name="do" value="登録">
        </form>
        [備考]<br>
        種別１：食料品<br>
        種別２：清涼飲料水<br>
        種別３：雑貨<br>
        種別４：雑誌<br>
        種別５：タバコ<br>
        種別６：酒類<br>
        種別７：金券
    </body>
    <br><br>
    <a href="top.jsp">トップへ戻る</a>
</html>
