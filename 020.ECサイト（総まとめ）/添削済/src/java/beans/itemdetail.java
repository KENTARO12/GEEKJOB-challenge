/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *yahooAPI上の商品情報を保管するためのBean。
 * @author guest1Day
 */
public class itemdetail implements java.io.Serializable{
    public itemdetail(){}

    private String name;
    private String price;
    private String imageURL;//medium
    
    private String code;//商品コード
    private String description;
    private String reviewrate;
    
    private String totalnumber;

    
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
    
    public String getImage() {
        return imageURL;
    }
    public void setImage(String image) {
        this.imageURL = image;
    }
    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getDesc() {
        return description;
    }
    public void setDesc(String desc) {
        this.description = desc;
    }
    
    
    public String getRate() {
        return reviewrate;
    }
    public void setRate(String rate) {
        this.reviewrate = rate;
    }
    
    public String getTotal() {
        return totalnumber;
    }
    public void setTotal(String total) {
        this.totalnumber = total;
    }
}

