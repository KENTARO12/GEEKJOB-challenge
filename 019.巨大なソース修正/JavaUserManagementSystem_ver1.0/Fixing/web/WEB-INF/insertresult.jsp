<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="beans.JumBean" %>
<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%JumBean jb = (JumBean) hs.getAttribute("userInfo");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前:<%= jb.getName()%><br>
        生年月日:<%= jb.getBirthday()%><br>
        種別:<%= jb.getType()%><br>
        電話番号:<%= jb.getTel()%><br>
        自己紹介:<%= jb.getInfo()%><br>
        以上の内容で登録しました。<br>
        
        
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
