<%-- 
    Document   : searchresult
    Created on : 2018/07/30, 17:02:36
    Author     : guest1Day
--%>
<%@page import="java.net.URLEncoder"%>
<%@page import="beans.itemdetail"
        import="java.util.ArrayList"
        import="java.net.HttpURLConnection"
        import="beans.gototop"%>
<%
    HttpSession hs = request.getSession();
    String str = (String)hs.getAttribute("staff");//検索キーワード
    String totalnum = (String)hs.getAttribute("totalnum");//検索総数
    ArrayList<itemdetail> array = (ArrayList)hs.getAttribute("result");
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
        <title>検索結果</title>
    </head>
    <body>
        <% if(hs.getAttribute("loginUser")==null){%>
            <div align="right">
            <a href="ud_Login.jsp?url=searchresult.jsp" >ログイン</a>
            <a href="ud_Registration.jsp?url=searchresult.jsp">新規登録</a><br><br>
            </div>
        <%}else{%>
            <div align="right">
            <a href="UD_Logout" >ログアウト</a>
            <a href="ud_Mydata.jsp">登録情報の確認</a>
            <h3><a href="cart.jsp">myカート</a></h3>
            </div>
        <%}%>
        <form action="Search" method="GET">
            <input type="text" name="search" value="<%=str%>" class="width">
            <input type="submit" name="do" value="検索">
        </form>
        検索結果　<%=totalnum%>件<%
        if(Integer.parseInt(totalnum)>10){%>
        (上位１０件を表示しています)<%}%><br><br>
        
        <%--cssの記述方法がわからないため、サムネと文字を同列に表示するのは保留。--%>
        <%
        for(int i = 0;i<array.size();i++){
            itemdetail result = array.get(i);%>
            <image src=<%=result.getImage()%>/><br>
            <a href="Item?id=<%=result.getCode()%>"><%=result.getName()%></a>
            <div align="right">
            <%=result.getPrice()%>円</div><br><br>
        <%}%>
    </body>
    <br>
    <h5><%=gototop.getInstance().home()%></h5>
</html>
