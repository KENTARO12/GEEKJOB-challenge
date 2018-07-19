package beans;

import java.sql.Timestamp;
import java.util.Date;

/**
 * ユーザー情報を持ちまわるJavaBeans
 * データベースのカラムと型に対応させている(DTO)。データの挿入、取り出しどちらにも便利
 * @version 1.00
 * @author hayashi-s
 */
public class UserDataDTO implements java.io.Serializable{
    
    public UserDataDTO(){
        this.name = "";
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.tell = "";
        this.type = "";
        this.comment= "";
        this.birthday= null;
        this.newDate= null;
        this.month2="";
        this.year2 = "";
        this.day2 = "";
        this.birthday2 = "";
    }
    
    private Date birthday;
    private Timestamp newDate;
    
    
    
    private int UserID;
    private String name;
    private int year;
    private int month;
    private int day;
    private String tell;
    private String type ;
    private String comment;
    private String update;
    private String year2;
    private String month2;
    private String day2;
    private String birthday2;
    
     public int getUserID() {
        return UserID;
    }
    public void setUserID(int ID) {
        this.UserID = ID;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        //空文字(未入力)の場合空文字をセット
        if(name.trim().length()==0){
            this.name = "";
        }else{
            this.name = name;
        }
    }

    public int getYear() {
        return year;
    }
    public void setYear(String year) {
        //初期選択状態の場合0をセット
        if(year.equals("")){
            this.year = 0;
        }else{
            this.year = Integer.parseInt(year);
        }
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(String month) {
        if(month.equals("")){
            this.month = 0;
        }else{
            this.month = Integer.parseInt(month);
        }
    }

    public int getDay() {
        return day;
    }
    public void setDay(String day) {
        if(day.equals("")){
            this.day = 0;
        }else{
            this.day = Integer.parseInt(day);
        }
    }

    public String getTell() {
        return tell;
    }
    public void setTell(String tell) {
        if(tell.trim().length()==0){
            this.tell = "";
        }else{
            this.tell = tell;
        }
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        if(type == null){
            this.type = "";
        }else{
            this.type = type;
        }
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        if(comment.trim().length()==0){
            this.comment = "";
        }else{
            this.comment = comment;
        }
    }
    
    public String getUpDate() {
        return update;
    }
    public void setUpDate(String update) {
        if(update == null){
            this.update = "";
        }else{
            this.update = update;
        }
    }
    
    
    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    
    public Timestamp getNewDate() {
        return newDate;
    }
    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }
    
    public String getBirthday2(){
        this.birthday2 = this.year2 +"-"+ this.month2 +"-"+ this.day2;
        return birthday2;
    }
    public void setYear2(String date){
        this.year2 = date;
    }
    public String getYear2(){
        return year2;
    }
    
    public void setMonth2(String date){
        this.month2 = date;
    }
    public String getMonth2(){
        return month2;
    }
    
    public void setDay2(String date){
        this.day2 = date;
    }
    public String getDay2(){
        return day2;
    }

}
