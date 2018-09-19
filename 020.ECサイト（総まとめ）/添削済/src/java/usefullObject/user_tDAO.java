/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usefullObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import beans.user;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author guest1Day
 */
public class user_tDAO {
    public static user_tDAO getInstance(){
        return new user_tDAO();
    }
    
    /**
     * "insert"処理を行う。現在時刻は挿入直前に生成
     * UD_RegistrationComplete.javaで使う。
     */
    public void insert(user udAlt) throws SQLException{
        Connection db_con = null;
        PreparedStatement db_st = null;
        try{
            db_con = DBManager.getConnection();
            db_st =  db_con.prepareStatement("INSERT INTO user_t (name,password,mail,address,newDate) VALUES (?,?,?,?,?)");
            db_st.setString(1,udAlt.getName());
            db_st.setString(2,udAlt.getPassword());
            db_st.setString(3,udAlt.getMail());
            db_st.setString(4,udAlt.getAddress());
            java.util.Date time = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = sdf.format(time);
            db_st.setString(5,strDate);
            
            db_st.executeUpdate();
            //System.out.println("insert completed");//いるかな？
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(db_st != null){
                db_st.close();
            }
            if(db_con != null){
                db_con.close();
            }
        }

    }
    
    /**
     * "update"処理を行う。現在時刻は挿入直前に生成
     * UD_DeleteComplete.javaとUD_UpdateComplete.javaで使う。
     */
    public void update(user newUD) throws SQLException{
        Connection db_con = null;
        PreparedStatement db_st = null;
        try{
            db_con = DBManager.getConnection();
            db_st =  db_con.prepareStatement("UPDATE user_t SET name=?,password=?,mail=?,address=?,newDate=?,deleteFlg=?,total=? WHERE userID=?");
            db_st.setString(1,newUD.getName());
            db_st.setString(2,newUD.getPassword());
            db_st.setString(3,newUD.getMail());
            db_st.setString(4,newUD.getAddress());
            java.util.Date time = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = sdf.format(time);
            db_st.setString(5,strDate);
            db_st.setInt(6,newUD.getDeleteFlg());
            db_st.setInt(7,newUD.getTotal());
            db_st.setInt(8,newUD.getUserID());
            
            db_st.executeUpdate();
            //System.out.println("update completed");//いるかな？
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(db_st != null){
                db_st.close();
            }
            if(db_con != null){
                db_con.close();
            }
        }

    }
    
    /**
     * "select"処理を行う。現在時刻は挿入直前に生成
     * UD_UpdateComplete.javaとUD_LoginConfirm.javaで使う。
     */
    public user select(user loginUD) throws SQLException, ParseException{
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        try{
            user ud = new user();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            db_con = DBManager.getConnection();
            db_st =  db_con.prepareStatement("SELECT userID,name,password,mail,address,total,newDate FROM user_t WHERE name=? AND password=? AND deleteFlg=0 AND userID!=?");
            db_st.setString(1,loginUD.getName());
            db_st.setString(2,loginUD.getPassword());
            db_st.setInt(3,loginUD.getUserID());//これを書かないと、住所やメールアドレスだけを変えることができなくなる。
            db_data = db_st.executeQuery();
            while(db_data.next()){
                ud.setUserID(db_data.getInt("userID"));
                ud.setName(db_data.getString("name"));
                ud.setPassword(db_data.getString("password"));
                ud.setMail(db_data.getString("mail"));
                ud.setAddress(db_data.getString("address"));
                ud.setTotal(db_data.getInt("total"));
                Date date = sdf.parse(db_data.getString("newDate"));
                ud.setNewDate(date);
                //該当結果が複数の場合の処理は考えていません
            }
            
            //System.out.println("select completed");//いるかな？
            return ud;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(db_data != null){
                db_data.close();
            }
            if(db_st != null){
                db_st.close();
            }
            if(db_con != null){
                db_con.close();
            }
        }
    }
}
