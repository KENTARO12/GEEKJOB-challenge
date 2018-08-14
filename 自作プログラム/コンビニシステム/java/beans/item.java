/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author guest1Day
 */
public class item implements Serializable{
    public item(){};
    private String name;
    private int price;
    private int type;
    private String code;
    private int number;
    private Date lastdate;
    private String place;
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
    
    public int getNumber(){
        return number;
    }
    public void setNumber(int num){
        this.number = num;
    }
    
    public Date getDate(){
        return lastdate;
    }
    public void setDate(Date date){
        this.lastdate = date;
    }
    
    public String getPlace(){
        return place;
    }
    public void setPlace(String place){
        this.place = place;
    }
}
