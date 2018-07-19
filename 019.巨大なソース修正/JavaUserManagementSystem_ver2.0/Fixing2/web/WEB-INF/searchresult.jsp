<%@page import="java.util.ArrayList"
        import="jums.JumsHelper"
        import="beans.UserDataDTO"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udb = new UserDataDTO();
    ArrayList array = (ArrayList)hs.getAttribute("SerchResult");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日</th>
            </tr>
            <tr>
                <%for(int i = 0;i<array.size();i++){
                    udb = (UserDataDTO)array.get(i);%>
                <td><a href="ResultDetail?id=<%= udb.getUserID()%>"><%= udb.getName()%></a></td>
                <td><%= udb.getYear()%></td>
                <td><%= udb.getType()%></td>
                <td><%= udb.getUpDate().substring(0,10)%></td>
            </tr>
            <%}%>
        </table>
    </body>
    <%=jh.home()%>
</html>
