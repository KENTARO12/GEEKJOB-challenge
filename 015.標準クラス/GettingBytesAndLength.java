/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;

/**
 *
 * @author guest1Day
 */
public class GettingBytesAndLength{
    public static void main(String[] args){
        String name = "菊地健太郎";
        System.out.println("文字数："+name.length());
        System.out.println("バイト数："+name.getBytes().length);
    }   
}
