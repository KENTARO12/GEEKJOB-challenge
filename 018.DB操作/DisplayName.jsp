<%-- 
    Document   : DisplayName
    Created on : 2018/06/29, 11:35:24
    Author     : guest1Day
--%>

<%@page import="java.lang.*"%>
<%@page import="java.sql.*"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>氏名　検索結果</title>
    </head>
    <body>
<%
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        try{
          Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","Kenneth","password");
            
            //db_st...prepareStatementメソッド用の変数
            db_st = db_con.prepareStatement("SELECT * FROM profiles WHERE name LIKE ?");
            //setInt,setBoolean,setDate,setStringなどがある。（ほかにもある)
            
            request.setCharacterEncoding("utf-8");
            
            String str = "%"+request.getParameter("name")+"%";
            db_st.setString(1,str);
            
            //db_data...ResultSetメソッド用の変数
            db_data = db_st.executeQuery();
            while(db_data.next()){
                //getString,getRow,getIntなどがある（ほかにもある）。
                out.print("id:"+db_data.getInt("profilesID")+", ");
                out.print("名前:"+db_data.getString("name")+", ");
                out.print("電話番号:"+db_data.getString("tel")+", ");
                out.print("年齢:"+db_data.getInt("age")+", ");
                out.print("生年月日:"+db_data.getDate("birthday")+", "+"<br>");               
            }
            out.print("ほかの該当結果はありません");
            db_data.close();
            db_st.close();
            db_con.close();           
        } catch (SQLException e_sql){
            System.out.println("接続時にエラーが発生しました："+e_sql.toString());
        } catch (Exception e){
            System.out.println("接続時にエラーが発生しました2："+e.toString());
        }finally{
            if(db_con != null){
                try{
                    db_con.close();
                }catch(Exception e_con){
                    System.out.println(e_con.getMessage());
                }
            }
        }
%>
        </body>
</html>
