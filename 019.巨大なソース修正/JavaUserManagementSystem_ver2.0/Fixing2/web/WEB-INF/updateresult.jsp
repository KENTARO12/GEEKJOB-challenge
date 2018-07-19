<%@page import="java.text.SimpleDateFormat"
        import="java.util.Date"
        import="jums.JumsHelper"
        import="beans.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("update");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
<%--
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    Date birth = udd.getBirthday();
    String dateString = sdf.format(birth);
--%>
        <h1>変更結果</h1><br>
        名前:<%= udd.getName()%><br>
        生年月日:<%= udd.getBirthday2()%><br>
        種別:<%= udd.getType()%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        以上の内容で情報を更新しました。<br>
    </body>
    <%=jh.home()%>
    </body>
</html>
