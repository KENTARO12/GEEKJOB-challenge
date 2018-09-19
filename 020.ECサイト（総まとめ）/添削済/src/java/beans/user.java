/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

/**
 *
 * @author guest1Day
 */
public class user implements java.io.Serializable{
    public user(){}
    
    private int userID=0;
    private String name;
    private String password;
    private String mail;
    private String address;
    private int total=0;
    private Date newDate;//String型にして、mysqlのほうでcurrent_timestampじゃだめ?
    private int deleteFlg = 0;
    
    public int getUserID() {
        return userID;
    }
    public void setUserID(int ID) {
        this.userID = ID;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String pass) {
        this.password = pass;
    }
    
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail= mail;
    }
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    
    public Date getNewDate() {
        return newDate;
    }
    public void setNewDate(Date date) {
        this.newDate=date;
    }
    
    public int getDeleteFlg() {
        return deleteFlg;
    }
    public void setDeleteFlg(int delete) {
        this.deleteFlg = delete;
    }
}

