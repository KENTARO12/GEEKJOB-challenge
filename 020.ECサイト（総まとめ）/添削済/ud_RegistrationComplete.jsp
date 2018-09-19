<%-- 
    Document   : ud_RegistrationComplete
    Created on : 2018/07/30, 16:54:59
    Author     : guest1Day
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.HttpSession"
        import="beans.gototop"
        import="beans.user" %>
<%
    HttpSession hs = request.getSession();
    user ud = (user)hs.getAttribute("udAlt");
    user login = new user();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前：<%= ud.getName()%><br>
        パスワード：<%= ud.getPassword()%><br>
        メールアドレス：<%= ud.getMail()%><br>
        お届け先住所：<%= ud.getAddress()%><br>
        以上の内容で登録しました。<br>
<%--
            login.setName(ud.getName());
            login.setPassword(ud.getPassword());
            login.setMail(ud.getMail());
            login.setAddress(ud.getAddress());
            login.setTotal(0);
            java.util.Date time = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = sdf.format(time);
            login.setNewDate(sdf.parse(strDate));
            
            hs.setAttribute("loginUser",login);
--%>

<%--ユーザーIDが必要ならこっち。でもDBに接続するからメモリの無駄が大きい。--%>
<%          Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kagoyume_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","Kenneth","password");
            
            db_st = db_con.prepareStatement("SELECT * FROM user_t WHERE name = ? AND password = ?");
            db_st.setString(1,ud.getName());
            db_st.setString(2,ud.getPassword());
            db_data = db_st.executeQuery();
            
            int userID = 0;
            while(db_data.next()){
                userID = db_data.getInt("userID");
            }
            
            login.setUserID(userID);
            login.setName(ud.getName());
            login.setPassword(ud.getPassword());
            login.setMail(ud.getMail());
            login.setAddress(ud.getAddress());
            login.setTotal(0);
            java.util.Date time = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = sdf.format(time);
            login.setNewDate(sdf.parse(strDate));
            
            hs.setAttribute("loginUser",login);
            db_data.close();
            db_st.close();
            db_con.close();
            
            String url = null;
            if(hs.getAttribute("referer")!=null){
                url = (String)hs.getAttribute("referer");
            }else{
                url = "top.jsp";
            }
%>
        <br>
        <a href="<%=url%>">元の画面に戻る</a>
        <br><br>
        <%=gototop.getInstance().home()%>
    </body>
</html>
