/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usefullObject;

import beans.historybean;
import beans.itemdetail;
import beans.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author guest1Day
 */
public class buy_tDAO {
    public static buy_tDAO getInstance(){
        return new buy_tDAO();
    }
    
    
    /**
     * "insert"処理を行う。現在時刻は挿入直前に生成
     * Buycomplete.javaで使う。
     */
    public void insert(int userID,int type,ArrayList<itemdetail> cart) throws SQLException{
        Connection db_con = null;
        PreparedStatement db_st = null;
        try{
            java.util.Date time = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = sdf.format(time);
            
            ArrayList<itemdetail> array = cart;
            db_con = DBManager.getConnection();
            db_st =  db_con.prepareStatement("INSERT INTO buy_t (userID,itemCode,type,buyDate,name,price)VALUES(?,?,?,?,?,?)");
            for(int i = 0;i<array.size();i++){
                db_st.setInt(1,userID);
                db_st.setString(2,array.get(i).getCode());
                db_st.setInt(3,type);
                db_st.setString(4,strDate);
                db_st.setString(5,array.get(i).getName());
                int price = Integer.parseInt(array.get(i).getPrice());
                db_st.setInt(6,price);

                db_st.executeUpdate();
            }
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
     * "select"処理を行う。現在時刻は挿入直前に生成
     * UD_History.javaとBuycomplete.javaで使う。
     */
    public ArrayList select(int userID) throws SQLException, ParseException{
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        try{
            ArrayList<historybean> array = new ArrayList<historybean>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            db_con = DBManager.getConnection();
            
            db_st =  db_con.prepareStatement("SELECT buyID,userID,itemCode,type,buyDate,name,price FROM buy_t WHERE userID=?");
            db_st.setInt(1,userID);
            db_data = db_st.executeQuery();
            while(db_data.next()){
                historybean history = new historybean();
                
                history.setBuyID(db_data.getInt("buyID"));
                history.setUserID(userID);
                history.setCode(db_data.getString("itemCode"));
                history.setType(db_data.getInt("type"));
                Date date = sdf.parse(db_data.getString("buyDate"));
                history.setBuyDate(date);
                history.setName(db_data.getString("name"));
                history.setPrice(db_data.getInt("price"));
                
                array.add(history);
            }

            //System.out.println("select completed");//いるかな？
            return array;
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
