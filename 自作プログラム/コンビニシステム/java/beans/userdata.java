/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author guest1Day
 */
public class userdata implements Serializable{
    public userdata(){}
    
    private String name;
    private int id;
    private int status;
    private String password;
    
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    
    public int getStatus(){
        return status;
    }
    public void setStatus(int status){
        this.status = status;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String pass){
        this.password = pass;
    }
}
