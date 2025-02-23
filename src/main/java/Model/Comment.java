/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author USER
 */
public class Comment {

    
    private long autorID;
    private String text;

    public Comment(long autorID, String text) {
        this.autorID = autorID;
        
        this.text = text;
    }
    public Comment(){
        this.autorID = 0;
        
        this.text = "";
    }

    public long getAutorID () {
        return this.autorID;
    }

    public String getText () {
        return this.text;
    }
    public void setAutorID(long autorID) {
        this.autorID = autorID;
    }

    public void setText(String text) {
        this.text = text;
    }
}
