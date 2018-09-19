/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usefullObject;

/**
 *
 * @author guest1Day
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static String address = "jdbc:mysql://localhost:3306/kagoyume_db";
    private static String patch = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String user = "Kenneth";
    private static String password = "password";
    
    public static Connection getConnection(){
        Connection db_con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");//.newInstance();//.newInstanceってどういう意味？
            db_con = DriverManager.getConnection(address+patch,user,password);
            System.out.println("DBConnected!!");
            return db_con;
        } catch (ClassNotFoundException e){
            throw new IllegalMonitorStateException();
        } catch (SQLException e) {
            throw new IllegalMonitorStateException();
        }
    }
}
