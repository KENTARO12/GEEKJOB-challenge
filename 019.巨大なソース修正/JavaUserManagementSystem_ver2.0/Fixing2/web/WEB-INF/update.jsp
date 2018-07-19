<%@page import="java.text.SimpleDateFormat"
        import="java.util.Date"
        import="jums.JumsHelper"
        import="javax.servlet.http.HttpSession"
        import="beans.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
<%
    Date birth = udd.getBirthday();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    String dateString = sdf.format(birth);
%>
    <form action="UpdateResult" method="POST">
        <%--入力フォーム内にあらかじめ詳細情報を記入しておくよりも
        隣に併記したほうがわかりやすいのでは、と考えました--%>
        名前:<%= udd.getName()%> → <input type="text" name="name" value="">
        <br><br>

        生年月日:<%= dateString%> → 
        <select name="year">
            <option value="">----</option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" ><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:<%= udd.getType()%> → 
        <select name="type">
            <option value=""　selected>選択してください</option>
            <option value="エンジニア">エンジニア</option>
            <option value="営業">営業</option>
            <option value="その他">その他</option>
        </select>
        <br>
        <br>

        電話番号:<%= udd.getTell()%> → 
        <input type="text" name="tell" value="">
        <br><br>

        自己紹介文
        <br>
        <%= udd.getComment()%><br>　↓<br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"></textarea><br><br>
        
        <input type="submit" name="btnSubmit" value="変更する">
    </form>
        <br>
        <%--詳細画面へ戻るボタンは、ブラウザの戻るボタンで十分代用できると
        考えたため、作ってません--%>
        <%=jh.home()%>
    </body>
</html>
