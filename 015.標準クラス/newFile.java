/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp;
import java.io.*;

/**
 *
 * @author guest1Day
 */
public class newFile {
    public static void main(String[] args) throws IOException{
        File fp = new File("java.txt");
/*      String str = fp.getAbsolutePath();
        System.out.println("pass: "+str);   */
        FileWriter fw = new FileWriter(fp);
        fw.write("ドウモ、ぼくドラえもんです。");
        fw.close();
    }
}
