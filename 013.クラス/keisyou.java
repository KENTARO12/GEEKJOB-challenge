/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

/**
 *
 * @author guest1Day
 */
public class keisyou {   
}
class Vegan extends Veges{
    public void clear(){
            VegesInfo("","","");
    }
}

class Sample2{
    public static void main(String[] args){
        Vegan tomato;
        tomato = new Vegan();
        tomato.VegesInfo("トマト","燃えるような夏", "炎のような赤");
        tomato.VegesList();
        tomato.clear();
        tomato.VegesList();
    }
}
