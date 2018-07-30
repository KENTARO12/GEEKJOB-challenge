<%-- 
    Document   : item
    Created on : 2018/07/29, 9:09:44
    Author     : user
--%>
<%@page import="beans.itemdetail"
        import="java.util.ArrayList"
        import="java.net.HttpURLConnection"
        import="beans.gototop"%>
<%
    gototop gto = gototop.getInstance();
    HttpSession hs = request.getSession();
    if(hs.getAttribute("link")!=null){
    hs.removeAttribute("link");}
    hs.setAttribute("link","item.jsp");
    ArrayList<itemdetail> array = (ArrayList)hs.getAttribute("result");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品詳細</title>
    </head>
    <body>
    <% if(hs.getAttribute("loginUser")==null){%>
        <div align="right">
        <a href="login.jsp" >ログイン</a>
        <a href="registration.jsp">新規登録</a><br><br>
        </div>
    <%}else{%>
        <div align="right">
        <a href="logout" >ログアウト</a>
        <a href="mydata.jsp">登録情報の確認</a>
        <h3><a href="cart.jsp">myカート</a></h3>
        </div>
    <%}%>
<%
int id = (Integer)hs.getAttribute("id");
itemdetail item = new itemdetail();
try{/*
    id = Integer.parseInt(request.getParameter("id"));
    hs.setAttribute("id",id);*/
    item = array.get(id);
}catch(Exception e){/*
    String idalt=(String)hs.getAttribute("id");
    item = array.get(Integer.parseInt(idalt));*/
}
%>
        <image src=<%=item.getImage()%>/><br>
        <h3><%=item.getName()%><br>
        <%=item.getPrice()%>円
        <div align="right">
        <%if(hs.getAttribute("loginUser")!=null){%>
            <a href="add?id=<%=id%>">
        <%}else{%>
            <a href="login.jsp?id=1">
        <%}%>カートに追加</a></div></h3>
        <h5>商品コード:<%=item.getCode()%></h5>
        評価：<%=item.getRate()%><br>
        詳細：<br><%=item.getDesc()%><br>
        
    </body>
    <br>
    <a href="searchresult.jsp">検索結果に戻る</a>
    <br>
    <h5><%=gototop.getInstance().home()%></h5>
</html>
