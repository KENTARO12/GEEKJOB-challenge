/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author guest1Day
 */
public class earningTotal implements Serializable{
    public earningTotal(){};
    private int totalEarn;
    private int type1Earn;
    private int type2Earn;
    private int type3Earn;
    private int type4Earn;
    private int type5Earn;
    private int type6Earn;
    private int type7Earn;
    
     
    public int getTotal(){
        return totalEarn;
    }
    public void setTotal(int total){
        this.totalEarn = total;
    }
    
    public int getType1(){//食品
        return type1Earn;
    }
    public void setType1(int type1){
        this.type1Earn = type1;
    }
    
    public int getType2(){//清涼飲料水
        return type2Earn;
    }
    public void setType2(int type2){
        this.type2Earn = type2;
    }
    
    public int getType3(){//雑貨
        return type3Earn;
    }
    public void setType3(int type3){
        this.type3Earn = type3;
    }
    
    public int getType4(){//雑誌
        return type4Earn;
    }
    public void setType4(int type4){
        this.type4Earn = type4;
    }
    
    public int getType5(){//たばこ
        return type5Earn;
    }
    public void setType5(int type5){
        this.type5Earn = type5;
    }
    
    public int getType6(){//酒類
        return type6Earn;
    }
    public void setType6(int type6){
        this.type6Earn = type6;
    }
    
    public int getType7(){//金券
        return type7Earn;
    }
    public void setType7(int type7){
        this.type7Earn = type7;
    }
    
    
    
}
