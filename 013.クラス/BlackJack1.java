/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author guest1Day
 */
public class BlackJack1 {
    public static void main(String[] args){
        Dealer dealer0 = new Dealer();
        int total = 0;
        for(int sum:dealer0.cards){
            total += sum;
        }
        System.out.print(total+"dayo~");
    }
}

abstract class Human{
    //手札の情報
    ArrayList<Integer> myCards = new ArrayList<Integer>();
    
    //手札の合計値としてopenを実装
    abstract public int open();
    
    //引いたカードを手札に加える動作としてsetCardを実装
    abstract public void setCard(ArrayList<Integer> AL);
    
    //山札からカードを引くかどうか判断する動作としてcheckSumを実装
    abstract public boolean checkSum();
}


class User extends Human{
    //手札の内容
    ArrayList<Integer> myCards = new ArrayList<Integer>();
    
    //手札の合計値
    public int open(){
        int sum=0;
        for(int total: myCards){
            sum = sum + total;
        }
        return sum;
    }
    
    //ディーラーがヒット(およびディール)したカードを手札に加える動作
    public void setCard(ArrayList<Integer> AL){
        //ALをmyCardsに加えたい
        myCards.addAll(AL);
    }

    //手札の合計値が２１未満かどうかの判定
    public boolean checkSum(){
        //openを埋め込んで無理やり計算している。もっといい方法がありそう。
        //例えば引数にopenを持ってくるのはどうだろう。
        int sum=0;
        for(int total: myCards){
            sum = sum + total;
        }

        if(sum<22){
            return true;
        }else{
            return false;
        }
    }
    
}


class Dealer extends Human{       
        //山札としてcardsを実装
    ArrayList<Integer> cards = new ArrayList<Integer>(52);
    
        /*山札を補充するためにコンストラクタを実装
          size取得→要素数分remove→要素add*/  
    public Dealer(){
        for(int i = 0; i<cards.size();i++){
            cards.remove(i);
        }
        {   cards.add(1);
            cards.add(1);
            cards.add(1);
            cards.add(1);
            cards.add(2);
            cards.add(2);
            cards.add(2);
            cards.add(2);
            cards.add(3);
            cards.add(3);
            cards.add(3);
            cards.add(3);
            cards.add(4);
            cards.add(4);
            cards.add(4);
            cards.add(4);
            cards.add(5);
            cards.add(5);
            cards.add(5);
            cards.add(5);
            cards.add(6);
            cards.add(6);
            cards.add(6);
            cards.add(6);
            cards.add(7);
            cards.add(7);
            cards.add(7);
            cards.add(7);
            cards.add(8);
            cards.add(8);
            cards.add(8);
            cards.add(8);
            cards.add(9);
            cards.add(9);
            cards.add(9);
            cards.add(9);
            cards.add(10);
            cards.add(10);
            cards.add(10);
            cards.add(10);
            cards.add(10);
            cards.add(10);
            cards.add(10);
            cards.add(10);
            cards.add(10);
            cards.add(10);
            cards.add(10);
            cards.add(10);
            cards.add(10);
            cards.add(10);
            cards.add(10);
            cards.add(10);
        }
    }
     
    public ArrayList<Integer> deal(){     
        //cardsからランダムで２枚引く
        Random rand = new Random();
        int randNumber1 = rand.nextInt(51);
        int randNumber2 = rand.nextInt(51);
        cards.get(randNumber1);
        cards.get(randNumber2);
        cards.remove(randNumber1);
        cards.remove(randNumber2);
        
        //新しい配列を作り、そこに上記の数字を格納する
        ArrayList<Integer> dealAlt = new ArrayList<Integer>(2);
        dealAlt.add(cards.get(randNumber1));
        dealAlt.add(cards.get(randNumber2));
        return dealAlt;
    }
    
    public ArrayList<Integer> hit(){
        Random rand = new Random();
        int randNumber = rand.nextInt(51);
        cards.get(randNumber);
        cards.remove(randNumber);
        
        //上記の数字をArrayListに入れるため、新規にArrayListを作る
        ArrayList<Integer> hitAlt = new ArrayList<Integer>();
        hitAlt.add(cards.get(randNumber));
        return hitAlt;
    }
    
    
    //humanクラスの継承条件として、abstractメソッド、フィールドの設定
    ArrayList<Integer> myCards = new ArrayList<Integer>();
    
    public int open(){
        int total=0;
        for(int sum: myCards){
            total = total + sum;
        }
        return total;
    }
    
    public void setCard(ArrayList<Integer> AL){
        myCards.addAll(AL);
    }

    public boolean checkSum(){
        int sum=0;
        for(int total: myCards){
            sum = sum + total;
        }

        if(sum<22){
            return true;
        }else{
            return false;
        }
    }

}