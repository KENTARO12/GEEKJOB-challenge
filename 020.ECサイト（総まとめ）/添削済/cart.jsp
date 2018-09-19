<%-- 
    Document   : cart
    Created on : 2018/07/30, 16:59:37
    Author     : guest1Day
--%>
<%-- 
    今回は"cart"+userIDという名前のセッションオブジェクトで済ませたが、
    本来はDBを使うべきな気がする。
--%>
<%@page import="beans.user"
        import="beans.itemdetail"
        import="java.util.ArrayList"
        import="beans.gototop"%>
<%
    HttpSession hs = request.getSession();
    user ud = (user)hs.getAttribute("loginUser");
    String strID = String.valueOf(ud.getUserID());
    ArrayList<itemdetail> cart = (ArrayList)hs.getAttribute("cart"+strID);
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
        if(cart.size()!=0){
            int total = 0;
            for(int i = 0;i<cart.size();i++){
                itemdetail content = cart.get(i);%>
                <image src=<%=content.getImage()%>/><br>
                <a href="Item?code=<%=content.getCode()%>&cart=0"><%=content.getName()%></a>
                <div align="right">
                <%=content.getPrice()%>円<br>
                <a href="Itemdelete?id=<%=i%>">カートから削除</a></div><br><br>    
            <%  total += Integer.parseInt(content.getPrice());
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
    <%//top画面からいきなりmyカートに進んだ場合のことを考えています。
        String url = null;
        if(hs.getAttribute("lastsearch")!=null){
            url=(String)hs.getAttribute("lastsearch");
        }else{
            url="top.jsp";
        }
    %>
    <a href="<%=url%>">検索結果に戻る</a>
    <br>
    <h5><%=gototop.getInstance().home()%></h5>
</html>
