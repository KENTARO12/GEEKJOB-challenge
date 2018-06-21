/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author guest1Day
 */
public class IndicatingTimeStamp2 {
    public static void main(String[] args) throws ParseException{
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date day1 = sdf1.parse("2015/01/01 00:00:00");
        
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date day2 = sdf2.parse("2015/12/31 23:59:59");
        
        System.out.println(day2.getTime()-day1.getTime());
    }   
}
