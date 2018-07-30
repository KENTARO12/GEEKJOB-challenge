<%-- 
    Document   : searchresult
    Created on : 2018/07/26, 16:51:08
    Author     : guest1Day
--%>
<%@page import="java.net.URLEncoder"%>
<%@page import="beans.itemdetail"
        import="java.util.ArrayList"
        import="java.net.HttpURLConnection"
        import="beans.gototop"%>
<%
    gototop gto = gototop.getInstance();
    HttpSession hs = request.getSession();
    String str = (String)hs.getAttribute("staff");
    if(hs.getAttribute("link")!=null){
    hs.removeAttribute("link");}
    hs.setAttribute("link","searchresult.jsp");
    ArrayList<itemdetail> array = (ArrayList)hs.getAttribute("result");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索結果</title>
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
        <form action="search" method="GET">
            <input type="text" name="search" value="<%=str%>" class="width">
            <input type="submit" name="do" value="検索">
        </form>
        検索結果　<%=array.size()%>件<br><br>
        
        <%--cssの記述方法がわからないため、サムネと文字を同列に表示するのは保留。--%>
        <%
        for(int i = 0;i<array.size();i++){
            itemdetail result = array.get(i);%>
            <image src=<%=result.getImage()%>/><br>
            <a href="item?id=<%=i%>"><%=result.getName()%></a>
            <div align="right">
            <%=result.getPrice()%>円</div><br><br>
        <%}%>
    </body>
    <br>
    <h5><%=gototop.getInstance().home()%></h5>
</html>
