<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession(false);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insert" method="POST">
        名前:
        <input required type="text" name="name" value="">
        <br><br>

        生年月日:
        <select required name="year">
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"> <%=i%> </option>
            <% } %>
        </select>年
        <select required name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>月
        <select required name="day">
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <%--
        <input type="radio" name="type" value="1" checked>エンジニア<br>
        <input type="radio" name="type" value="2">営業<br>
        <input type="radio" name="type" value="3">その他<br>
       --%>
        <select required name="type">
            <option value=""　selected>選択してください</option>
            <option value="エンジニア">エンジニア</option>
            <option value="営業">営業</option>
            <option value="その他">その他</option>
        </select>
        <br><br>

        電話番号:
        <input required type="text" name="tel" value="">
        <br><br>

        自己紹介文
        <br>
        <textarea required name="comment" rows=10 cols=50 style="resize:none" wrap="hard"></textarea><br><br>

        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
