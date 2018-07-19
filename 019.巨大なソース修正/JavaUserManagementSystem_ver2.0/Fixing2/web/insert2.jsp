<%-- 
    Document   : insert2
    Created on : 2018/07/09, 13:25:21
    Author     : guest1Day
--%>

<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="beans.JumBean" %>
<%
    HttpSession hs = request.getSession(false);
%>

<%--
insert.jspに戻るよりも、新しくjspファイルを作って
それを活用するほうが簡単だと考えました。
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%JumBean jb = (JumBean) hs.getAttribute("userInfo");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insert" method="POST">
        名前:
        <input required type="text" name="name" value="<%= jb.getName()%>">
        <br><br>

        生年月日:
        <select name="year">
            <option value="<%= jb.getYear()%>"><%= jb.getYear()%></option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"> <%=i%> </option>
            <% } %>
        </select>年
        <select name="month">
            <option value="<%= jb.getMonth()%>"><%= jb.getMonth()%></option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="<%= jb.getDay()%>"><%= jb.getDay()%></option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <select required name="type">
            <option value="<%= jb.getType()%>" selected="selected"><%= jb.getType()%></option>
            <option value="エンジニア">エンジニア</option>
            <option value="営業">営業</option>
            <option value="その他">その他</option>
        </select>
            <%--<%= jb.getType()%>に値は格納されているが、
            　それをうまくradioボタンに対して使えない。
             そのため、苦し紛れの方法としてradioボタンではなく
             selectタグを使った--%>
        <br><br>

        電話番号:
        <input required type="text" name="tel" value="<%= jb.getTel()%>">
        <br><br>

        自己紹介文
        <br>
        <textarea required name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= jb.getInfo()%></textarea><br><br>

        <input type="hidden" name="ac"  value="<%= hs.getAttribute("userinfo")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>

