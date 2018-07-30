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
public class historybean implements java.io.Serializable{
    public historybean(){}
    
    private int buyID=0;
    private int userID=0;
    private String name;
    private int price;
    private String itemCode;
    private int type;
    private Date buyDate;
    
    
    public int getBuyID() {
        return buyID;
    }
    public void setBuyID(int bID) {
        this.buyID = bID;
    }
    
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
    
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price= price;
    }
    
    public String getCode() {
        return itemCode;
    }
    public void setCode(String code) {
        this.itemCode = code;
    }
    
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type= type;
    }
    
    public Date getBuyDate() {
        return buyDate;
    }
    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
}
