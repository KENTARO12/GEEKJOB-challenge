/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *現在の日時を返却するクラス。売り上げ確認の時などに使う。
 * @author guest1Day
 */
public class returnNowDate implements Serializable{
    public returnNowDate(){};
    private int year;
    private int month;
    private int day;
    private String strDate;
    
    Date today = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
    String stringDate = sdf.format(today);
    public int getNowYear(){
        String nowyear = stringDate.substring(0,4);
        int intYear = Integer.parseInt(nowyear);
        this.year = intYear;
        return year;
    }
    
    public int getNowMonth(){
        String nowmonth = stringDate.substring(5,7);
        int intMonth = Integer.parseInt(nowmonth);
        this.month = intMonth;
        return month;
    }
    
    public int getNowDay(){
        String today1 = stringDate.substring(8,10);
        int inttoday = Integer.parseInt(today1);
        this.day = inttoday;
        return day;
    }
    
    public String getStrDate(){
        return strDate;
    }
    public void setStrDate(String strYear,String strMonth,String strDay){//earning.javaから検索対象年月日をもらってくる。
        String date = strYear+"年 "+strMonth+"月"+strDay+"日";
        this.strDate = date;
    }
}
