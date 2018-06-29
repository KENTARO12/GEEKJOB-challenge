<%-- 
    Document   : UpdateRecord
    Created on : 2018/06/29, 14:08:30
    Author     : guest1Day
--%>

<%@page import="java.sql.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>データ更新</title>
    </head>
    <body>
<%
    Connection db_con=null;
    PreparedStatement db_st=null;
    ResultSet db_data=null;
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","Kenneth","password");
        
        db_st = db_con.prepareStatement("UPDATE profiles SET name=?, tel=?, age=?,birthday=? WHERE profilesID = ?");//まだ未完成です
        
        request.setCharacterEncoding("utf-8");
        int num = Integer.parseInt(request.getParameter("id"));
        String str = request.getParameter("name");
        String str2 = request.getParameter("tel");
        int num2 = Integer.parseInt(request.getParameter("age"));
        Date day = Date.valueOf(request.getParameter("birth"));
        
        db_st.setString(1,str);
        db_st.setString(2,str2);
        db_st.setInt(3,num2);
        db_st.setDate(4,day);
        db_st.setInt(5,num);
        
        int row = db_st.executeUpdate();
        
        db_st = db_con.prepareStatement("SELECT * FROM profiles");
        db_data = db_st.executeQuery();
        while(db_data.next()){
            out.print("ID:"+db_data.getInt("profilesID")+",  ");
            out.print("name:"+db_data.getString("name")+",  ");
            out.print("tel:"+db_data.getString("tel")+",  ");
            out.print("age:"+db_data.getInt("age")+",  ");
            out.print("birthday:"+db_data.getDate("birthday")+"<br>");
        }
        db_data.close();
        db_st.close();
        db_con.close();
    }catch(SQLException e_sql){
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
