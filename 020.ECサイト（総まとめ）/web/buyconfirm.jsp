<%-- 
    Document   : buyconfirm
    Created on : 2018/07/29, 18:29:19
    Author     : user
--%>
<%@page import="beans.user"%>
<%@page import="beans.itemdetail"
        import="java.util.ArrayList"
        import="java.net.HttpURLConnection"
        import="beans.gototop"%>
<%
    gototop gto = gototop.getInstance();
    HttpSession hs = request.getSession();
    user ud = (user)hs.getAttribute("loginUser");
    int userID=ud.getUserID();
    String strID = String.valueOf(userID);
    ArrayList<itemdetail> array = (ArrayList)hs.getAttribute("cart"+strID);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>購入確認</title>
    </head>
    <body>
        <%
        int total = 0;
        for(int i = 0;i<array.size();i++){
            itemdetail result = array.get(i);%>
            <image src=<%=result.getImage()%>/><br>
            <%=result.getName()%>
            <div align="right">
            <%=result.getPrice()%>円</a></div><br><br>    
        <%  total += Integer.parseInt(result.getPrice());
        }%>
        <div align="right"><h2>total:<%=total%>円</h2></div>
        <form action="buycomplete1" method="GET">
            発送方法：<br><br>
            ご自宅へ配達<input required type="radio" name="type" value="1"><br>
            コンビニ店頭受け取り<input type="radio" name="type" value="2"><br>
            営業所受け取り<input type="radio" name="type" value="3"><br><br><br>
            <input type="submit" name="do" value="上記の内容で購入する">
        </form>

    </body>
    <br>
    <h5><%=gototop.getInstance().home()%></h5>
</html>
