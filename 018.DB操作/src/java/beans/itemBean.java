package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */
public class itemBean implements java.io.Serializable{
    public itemBean(){}

    private String name;
    private String price;
    private String number;
    

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    
    public String getNumber() {
        return number;
    }
    public void setNumber(String num) {
        this.number = num;
    }
    
    
}
