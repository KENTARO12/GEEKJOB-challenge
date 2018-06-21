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
public class ReplaceLetter {
    public static void main(String[] args){
        String sent = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        System.out.println(sent.replace("U","う").replace("I","い"));
    }
}
