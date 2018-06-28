/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;
import java.sql.*;

/**
 *
 * @author guest1Day
 */
public class INSERTrecord {
        public static void main(String[] args){  
        //db_con...getConnectionメソッド用の変数
        Connection db_con = null;
        PreparedStatement db_st = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","Kenneth","password");
            
            //db_st...prepareStatementメソッド用の変数
            db_st = db_con.prepareStatement("INSERT INTO profiles VALUES (6,'モホロビチッチ','0440-9988-7766',50,'1994-6-8')");
            //setInt,setBoolean,setDate,setStringなどがある。（ほかにもある）
         
            
            //db_data...ResultSetメソッド用の変数
            int row = db_st.executeUpdate();

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
    }
}
