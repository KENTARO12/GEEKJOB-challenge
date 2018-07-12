<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="beans.JumBean" %>
<%
    HttpSession hs = request.getSession(false);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body> <%--if文で
            if(!hs.getAttribute("name").equals(""))
        　と条件を付ける方法もあるが、insert.jspにてrequiredタグを
          使ったため、こちらでの記入は不必要になった--%>
        <%JumBean jb = (JumBean) hs.getAttribute("userInfo");%>
        <h1>登録確認</h1>
        名前:<%= jb.getName()%><br>
        生年月日:<%= jb.getBirthday()%><br>
        種別:<%= jb.getType()%><br>
        電話番号:<%= jb.getTel()%><br>
        自己紹介:<%= jb.getInfo()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult3" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>

        <form action="insert2.jsp" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
      <br>
      <%=JumsHelper.getInstance().home()%>
    </body>
</html>
