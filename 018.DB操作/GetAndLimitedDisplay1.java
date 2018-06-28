/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author guest1Day
 */
public class GetAndLimitedDisplay1 {
    public static void main(String[] args){  
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","Kenneth","password");
            
            db_st = db_con.prepareStatement("SELECT * FROM profiles");

            db_data = db_st.executeQuery();
            while(db_data.next()){
                System.out.print(db_data.getString("profilesID")+"/");
                System.out.print(db_data.getString("name")+"/");
                System.out.print(db_data.getString("tel")+"/");
                System.out.print(db_data.getString("age")+"/");
                System.out.println(db_data.getString("birthday"));
                }
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
    }
    
}
