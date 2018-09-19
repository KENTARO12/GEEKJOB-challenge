<%-- 
    Document   : item
    Created on : 2018/07/30, 16:58:23
    Author     : guest1Day
--%>
<%@page import="beans.itemdetail"
        import="java.util.ArrayList"
        import="java.net.HttpURLConnection"
        import="beans.gototop"%>
<%
    HttpSession hs = request.getSession();
    itemdetail item = (itemdetail)request.getAttribute("itemdetail");
    if(hs.getAttribute("udAlt")!=null){//ログイン時に、入力フォームに値を保持するためのセッション。
        hs.removeAttribute("udAlt");
    }
    if(hs.getAttribute("referer")!=null){//ログイン時に、どこから飛んできたかわかるようにするもの。
        hs.removeAttribute("referer");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品詳細</title>
    </head>
    <body>
    <%--String str = new String (request.getRequestURL());--%>
    <% if(hs.getAttribute("loginUser")==null){%>
        <div align="right">
        <a href="ud_Login.jsp?url=Item&id=<%=item.getCode()%>" >ログイン</a>
        <a href="ud_Registration.jsp?url=Item&id=<%=item.getCode()%>">新規登録</a><br><br>
        </div>
    <%}else{%>
        <div align="right">
        <a href="UD_Logout" >ログアウト</a>
        <a href="ud_Mydata.jsp">登録情報の確認</a>
        <h3><a href="cart.jsp">myカート</a></h3>
        </div>
    <%}%>
        <image src=<%=item.getImage()%>/><br>
        <h3><%=item.getName()%><br>
        <%=item.getPrice()%>円
        <div align="right">
        <%if(hs.getAttribute("loginUser")!=null){%>
            <a href="Addition?id=<%=item.getCode()%>">
        <%}else{%>
            <a href="ud_Login.jsp?url=Item&id=<%=item.getCode()%>">
        <%}%>カートに追加</a></div></h3>
        <h5>商品コード:<%=item.getCode()%></h5>
        評価：<%=item.getRate()%><br>
        詳細：<br><%=item.getDesc()%><br>
        
    </body>
    <br>
    <a href="<%=hs.getAttribute("lastsearch")%>">検索結果に戻る</a>
    <br>
    <h5><%=gototop.getInstance().home()%></h5>
</html>
