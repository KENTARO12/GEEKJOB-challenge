<%-- 
    Document   : top
    Created on : 2018/07/30, 17:03:43
    Author     : guest1Day
--%>
<%--
    注意点：
    ①カートの中身をセッションで保管している。（DBを作ったほうがいい？）
    ②nameとpasswordではなく、mailとpasswordでログインするようにすべき？
    ③mysqlからdatetimeを取り出す際、getStringでとりだしてsdf.parseでDate型に変換している。
    　(timestampで取り出すべき？)
    ④登録情報の更新画面で、何も変更せずに"更新"を押すと、ud_UpdateDenied.jspに飛ぶ。
     （処理を変えるべき？）
    課題点：
    ①DTOを作っていない。
     （userDataを持ちまわるbeansとどう違うの？）
    ②ファイル名に整合性がない。
    ③エラーメッセージをもう少しこだわりたい。
    ④JavaDockに触れていない。
    ⑤UD_History.javaの商品名から、商品詳細ページに飛びたい。
--%>
<%@page import="beans.gototop"
        import="beans.user"%>
<%
    HttpSession hs = request.getSession();
    if(hs.getAttribute("udAlt")!=null){//ログイン時に、入力フォームに値を保持するためのセッション。
        hs.removeAttribute("udAlt");
    }
    if(hs.getAttribute("referer")!=null){//ログイン時に、どこから飛んできたかわかるようにするもの。
        hs.removeAttribute("referer");
    }
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
    
    <form action="Search" method="GET">
        <input type="text" name="search" placeholder="何をお探しですか？" class="width">
        <input type="submit" name="do" value="検索">
    </form>
    <% if(hs.getAttribute("loginUser")==null){%><%--hs.get~はuddとすることもできる--%>
        <br><br>
        <a href="ud_Login.jsp?url=top.jsp" >ログイン</a><br>
        <a href="ud_Registration.jsp?url=top.jsp">新規登録</a><br>
    <%}else{%>
        <h3>
        <div align="right">
            ようこそ、<%=udd.getName()%>さん
            <a href="cart.jsp">myカート</a>
        </div></h3>
        <br>
        <a href="UD_Logout" >ログアウト</a><br>
        <a href="ud_Mydata.jsp">登録情報の確認</a><br>
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
