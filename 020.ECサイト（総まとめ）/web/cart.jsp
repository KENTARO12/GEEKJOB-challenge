<%-- 
    Document   : cart
    Created on : 2018/07/29, 9:57:24
    Author     : user
--%>
<%-- 
    今回は"cart"+userIDという名前のセッションオブジェクトで済ましたが、
    本来はDBを使うべきな気がする。
--%>
<%@page import="beans.user"%>
<%@page import="beans.itemdetail"
        import="java.util.ArrayList"
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
        <title>Myカート</title>
    </head>
    <body>
    <%
    try{
        if(array.size()!=0){
            int total = 0;
            for(int i = 0;i<array.size();i++){
                itemdetail result = array.get(i);%>
                <image src=<%=result.getImage()%>/><br>
                <a href="item.jsp?id=<%=i%>"><%=result.getName()%></a>
                <div align="right">
                <%=result.getPrice()%>円<br>
                <a href="itemdelete?id=<%=i%>">カートから削除</a></div><br><br>    
            <%  total += Integer.parseInt(result.getPrice());
            }%>
        
        <div align="right"><h2>合計:<%=total%>円</h2></div>
        <h2><a href="buyconfirm.jsp">購入する</a></h2>
        <%}else{%>
        <h2>お客様のショッピングカートに商品はありません</h2>
        <%}
    }catch(Exception e){%>
        <h2>お客様のショッピングカートに商品はありません</h2>
    <%}%>
    </body>
    <br>
    <a href="searchresult.jsp">検索結果に戻る</a>
    <br>
    <h5><%=gototop.getInstance().home()%></h5>
</html>
