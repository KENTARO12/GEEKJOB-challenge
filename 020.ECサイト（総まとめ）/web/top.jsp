<%-- 
    Document   : toppage
    Created on : 2018/07/20, 14:04:30
    Author     : guest1Day
--%>
<%@page import="beans.gototop"
        import="beans.user"%>
<%
    gototop gto = gototop.getInstance();
    HttpSession hs = request.getSession();
    if(hs.getAttribute("link")!=null){
    hs.removeAttribute("link");}
    hs.setAttribute("link","top.jsp");
    user udd = (user)hs.getAttribute("loginUser");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>yahoh トップページ</title>
    <style type="text/css">
        input.width { width: 50%; }
    </style>
</head>
<body>
    <h1>yahoh　ECサイト《ユメカゴ》</h1>
    
    <form action="search" method="GET">
        <input type="text" name="search" placeholder="何をお探しですか？" class="width">
        <input type="submit" name="do" value="検索">
    </form>
    <% if(hs.getAttribute("loginUser")==null){%><%--hs.get~はuddとすることもできる--%>
        <br><br>
        <a href="login.jsp" >ログイン</a><br>
        <a href="registration.jsp">新規登録</a><br>
    <%}else{%>
        <h3>
        <div align="right">
            <a href="cart.jsp">myカート</a>
        </div></h3>
        <br>
        <a href="logout" >ログアウト</a><br>
        <a href="mydata.jsp">登録情報の確認</a><br>
    <%}%>
    
    
    <h5>　ショッピングサイトを使っている時、こんな経験ありませんか？<br>

    「あれいいな」
    「これいいな」
    「あっ、関連商品のこれもいい」
    「20%オフセールだって！？買わなきゃ！」...<br>

    そしていざ『買い物かご』を開いたとき、その合計金額に愕然とします。
    「こんなに買ってたのか・・・しょうがない。いくつか減らそう・・・」<br>

    仕方がありません。無駄遣いは厳禁です。
    でも、一度買うと決めたものを諦めるなんて、ストレスじゃあありませんか？
    できればお金の事なんか考えずに好きなだけ買い物がしたい・・・。<br>

    このサービスは、そんなフラストレーションを解消するために生まれた、<br>

    『金銭取引が絶対に発生しない』
    『いくらでも、どんなものでも購入できる(気分になれる)』
    『ECサイト』<br>

    です。</h5><br>

</body>
</html>
