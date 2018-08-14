<%-- 
    Document   : top
    Created on : 2018/08/06, 10:11:33
    Author     : guest1Day

使用する環境は、個人経営の小さな小売店を想定（駄菓子屋みたいな）。
詳細店舗マップは別途のPDFファイルを参照のこと。
--%>
<%@page import="beans.returnNowDate"%>
<%@page import="java.util.Date"%>
<%@page import="beans.userdata"%>

<%
    HttpSession hs = request.getSession();
    userdata user = (userdata)hs.getAttribute("user");
    returnNowDate today = new returnNowDate();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>トップ画面</title>
    </head>
    <body>
        <%if(hs.getAttribute("user")==null){%>
            <form action="login" method="GET">
                従業員ID：<input type="int" name="id" placeholder="従業員ID"><br>
                パスワード：<input type="text" name="password" placeholder="パスワード" value=""><br>
                <input type="submit" name="do" value="ログイン">
            </form>
        <%}else{%>
        <h3>
        <div align="right">
            <a href="logout">ログアウト</a>
        </div></h3>
            <%switch(user.getStatus()){//ここ、もう少しスマートにできないかな？
                case 0:%>
                    <a href="stocklist">在庫一覧</a><br>
                    <a href="MoveToStocksearchJSP">在庫検索</a><br>
                    <%break;
                case 1:%>
                    <a href="stocklist">在庫一覧</a><br>
                    <a href="MoveToStocksearchJSP">在庫検索</a><br>
                    <a href="TryToStockinputJSP">在庫更新(売り上げ入力)</a><br>
                    売り上げ確認<br> 営業日：
                    <form action="earning" method="GET">
                        <select ruquired name="year">
                        <option value="<%=today.getNowYear()%>"><%=today.getNowYear()%></option>
                        <%
                        int onetime = today.getNowYear();
                        for(int i=1964; i<=onetime; i++){//1964年創業です！%>
                            <option value="<%=i%>"><%=i%></option>
                        <%}%>
                        </select>年
                        <select ruquired name="month">
                        <option value="<%=today.getNowMonth()%>"><%=today.getNowMonth()%></option>
                        <%
                        for(int i=1; i<=12; i++){%>
                            <option value="<%=i%>"><%=i%></option>
                        <%}%>
                        </select>月
                        <select ruquired name="day">
                        <option value="<%=today.getNowDay()%>"><%=today.getNowDay()%></option>
                        <%
                        for(int i=1; i<=31; i++){//ここの日付も月や年によって変えることもできるが、とりあえずこれで。%>
                            <option value="<%=i%>"><%=i%></option>
                        <%}%>
                        </select>日
                        <input type="submit" name="do" value="確認">
                    </form>
                    <%break;
                case 2:%>
                    <a href="stocklist">在庫一覧</a><br>
                    <a href="MoveToStocksearchJSP">在庫検索</a><br>
                    <a href="TryToStockinputJSP">在庫更新(売り上げ入力)</a><br>
                    売り上げ確認（営業日選択）：
                    <form action="earning" method="GET">
                        <select ruquired name="year">
                        <option value="<%=today.getNowYear()%>"><%=today.getNowYear()%></option>
                        <%
                        int onetime2 = today.getNowYear();
                        for(int i=1964; i<=onetime2; i++){//1964年創業です！%>
                            <option value="<%=i%>"><%=i%></option>
                        <%}%>
                        </select>年
                        <select ruquired name="month">
                        <option value="<%=today.getNowMonth()%>"><%=today.getNowMonth()%></option>
                        <%
                        for(int i=1; i<=12; i++){%>
                            <option value="<%=i%>"><%=i%></option>
                        <%}%>
                        </select>月
                        <select ruquired name="day">
                        <option value="<%=today.getNowDay()%>"><%=today.getNowDay()%></option>
                        <%
                        for(int i=1; i<=31; i++){//ここの日付も月や年によって変えることもできるが、とりあえずこれで。%>
                            <option value="<%=i%>"><%=i%></option>
                        <%}%>
                        </select>日
                        <input type="submit" name="do" value="確認">
                    </form>
                    <a href="TryToStockeditJSP">商品チェック、棚卸</a><br>
                    <a href="MoveToAdditemJSP">取扱商品の追加</a><br>
                    <a href="MoveToEmployeeJSP">従業員データの追加、編集</a><br>
                    <%break;
                case -1:%>
                    何も表示できません
                    <%break;
                default:%>
                    何も表示できません
                    <%break;
            }%>
        <%}%>
    </body>
</html>
