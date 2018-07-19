<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="jums.JumsHelper"
        import="beans.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");
    UserDataDTO search = (UserDataDTO)hs.getAttribute("Search");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
<%
    Date birth = udd.getBirthday();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    String dateString = sdf.format(birth);
%>
        <h1>詳細情報</h1>
        名前：<%= udd.getName()%><br>
        生年月日：<%= dateString%><br>
        種別：<%= udd.getType()%><br>
        電話番号：<%= udd.getTell()%><br>
        自己紹介：<%= udd.getComment()%><br>
        登録日時：<%= udd.getUpDate()%><br>
        <form action="Update" method="POST">
        <input type="submit" name="update" value="変更"style="width:100px">
        </form>
        <form action="Delete" method="POST">
        <input type="submit" name="delete" value="削除"style="width:100px">
        </form>
    </body>
    <%
        String name;
        if(search.getName()!=null){
            name = search.getName();
        }else{
            name = "";
        }
        
        int year;
        if(search.getYear()!=0){
            year = search.getYear();
        }else{
            year = 0;
        }
        
        String type;
        if(search.getType()!=null){
            type = search.getType();
        }else{
            type = "";
        }
        
        String url = "http://localhost:8080/Fixing2/SearchResult?name="+name+"&year="+year+"&type="+type+"&btnSubmit=%E6%A4%9C%E7%B4%A2";%>
    <a href=<%=url%>>検索結果画面へ戻る</a><br>
    <%=jh.home()%>
</html>
