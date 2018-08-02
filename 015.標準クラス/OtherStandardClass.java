/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author guest1Day
 */

/*ArrayList
要素を配列で保持している
配列がメモリ上でインデックス化されている
インデックスの修正、コピーに対するコストが要素数に比例して大きくなる
要素がメモリ上のインデックスに保管されているため、n番目の要素へのアクセスが早い

LinkedList
要素を数珠つなぎに保持している
前後の要素に対するリファレンスを保持している
要素の追加、削除はリファレンスの変更のみでOKのため、コストが一定
ある要素が何番目かが分からないため、n番目の要素に対して1から順にたどる必要がある*/
public class OtherStandardClass {
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i<10;i++){
            list.add(i);
        }
        
        //Listを介してArrayListからLinkedListに変換する。（拡張for文を利用）
        LinkedList<Integer> link = new LinkedList<Integer>(list);//引数にList変数名を入れる。
        for(Integer i : link) {
            System.out.print(i);
            if(i!=9){
                System.out.print(",");
            }else{
                System.out.println("");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("合計動作時間："+(end - start)  + "ミリ秒");
    }
}
