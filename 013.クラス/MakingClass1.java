/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import static java.lang.System.out;

/**
 *
 * @author guest1Day
 */
public class MakingClass1 {
}
class Veges {
    public String bestseason;
    public String color;
    
    public void VegesInfo(String b,String c){
        this.bestseason = b;
        this.color = c;
    }    
    public void VegesList(){
        out.print("この野菜の色は"+color+"で、旬は"+bestseason+"です。");
    }
}   

class Sample{
  public static void main (String[] args){   
    Veges corn = new Veges();
    corn.VegesInfo("summer","yellow");
    corn.VegesList();
  }  
}
