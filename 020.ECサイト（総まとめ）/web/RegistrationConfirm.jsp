<%-- 
    Document   : RegistrationConfirm
    Created on : 2018/07/20, 17:29:13
    Author     : guest1Day
--%>
<%@page import="beans.gototop"
        import="beans.user"%>

<%
    HttpSession hs = request.getSession();
    user ud = (user) hs.getAttribute("userInfo");
%>
        
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録確認画面</title>
    </head>
    <body>
        <h1>登録確認</h1>
        名前：<%= ud.getName()%><br>
        パスワード：<%= ud.getPassword()%><br>
        メールアドレス：<%= ud.getMail()%><br>
        お届け先住所：<%= ud.getAddress()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="RegistrationComplete" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>

        <form action="registration.jsp" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
      <br>
      <%=gototop.getInstance().home()%>
    </body>
</html>
