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
public class userbean implements java.io.Serializable{
    public userbean(){}
    
    private String name;
    private int gender;
    private String hobby;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public int getGender() {
        return gender;
    }
    public void setGender(int gen) {
        this.gender = gen;
    }
    
    public String getHobby() {
        return hobby;
    }
    public void setHobby(String hobby) {
        this.hobby= hobby;
    }
}
