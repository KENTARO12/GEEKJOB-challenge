/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author guest1Day
 */
public class IndicatingCurrentTime {
    public static void main(String[] args){
        Date d = new Date();       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy'年'MM'月'dd'日' k'時'mm'分'ss'秒'");
        System.out.println(sdf.format(d));
    }
    
}
