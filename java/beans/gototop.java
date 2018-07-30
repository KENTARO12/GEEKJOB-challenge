/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author guest1Day
 */
public class gototop {
    private final String homeURL = "top.jsp";
    
    public static gototop getInstance(){
        return new gototop();
    }
    
    public String home(){
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }
}
