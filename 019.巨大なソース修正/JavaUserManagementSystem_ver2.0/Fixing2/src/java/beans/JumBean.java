/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.io.Serializable;

/**
 *
 * @author guest1Day
 */
public class JumBean implements Serializable{
    
    private String name;
    private String birthday;
    private String type;
    private String tel;
    private String info;
    private String year;
    private String month;
    private String day;

    
    public JumBean(){}
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getBirthday(){
        this.birthday = this.year +"-"+ this.month +"-"+ this.day;
        return birthday;
    }
    public void setYear(String date){
        this.year = date;
    }
    public String getYear(){
        return year;
    }
    
    public void setMonth(String date){
        this.month = date;
    }
    public String getMonth(){
        return month;
    }
    
    public void setDay(String date){
        this.day = date;
    }
    public String getDay(){
        return day;
    }
    
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    
    public String getTel(){
        return tel;
    }
    public void setTel(String tel){
        this.tel = tel;
    }
    
    public String getInfo(){
        return info;
    }
    public void setInfo(String info){
        this.info = info;
    }
}

