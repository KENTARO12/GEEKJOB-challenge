<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="jums.JumsHelper"
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
        <title>JSP Page</title>
    </head>
    <body>
<%
    Date birth = udd.getBirthday();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    String dateString = sdf.format(birth);
%>
    <h1>削除確認</h1>
    以下の内容を削除します。よろしいですか？<br><br>
    名前:<%= udd.getName()%><br>
    生年月日:<%= dateString%><br>
    種別:<%= udd.getType()%><br>
    電話番号:<%= udd.getTell()%><br>
    自己紹介:<%= udd.getComment()%><br>
    登録日時:<%= udd.getUpDate()%><br><br>
    
    <form action="DeleteResult" method="POST">
      <input type="submit" name="YES" value="はい"style="width:100px">
    </form><br>
<%--
    ブラウザ上の戻るボタンを押せばいいだけだと考えたので、表示していません。
    <form action="ResultDetail" method="POST">
    <input type="submit" name="NO" value="詳細画面に戻る"style="width:100px">
--%>    
    </form>
    </body>
</html>
