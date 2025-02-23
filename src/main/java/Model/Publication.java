/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */

class Comment {
    private long autorID;
    private String autorName;
    private String text;

    public Comment(long autorID, String autorName, String text) {
        this.autorID = autorID;
        this.autorName = autorName;
        this.text = text;
    }

    public long getAutorID () {
        return this.autorID;
    }

    public String getAutorName () {
        return this.autorName;
    }

    public String getText () {
        return this.text;
    }
}

public class Publication {
    private long PUBLICATION_ID;
    private long AUTOR_ID;
    
    private String text;
    private int likes;
    private List<Comment> comments;
    private List<Long> usersWhoReacted;
    private LocalDateTime date;
    // Variable para la imagen (falta)

    public void setAUTOR_ID(long AUTOR_ID) {
        this.AUTOR_ID = AUTOR_ID;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setUsersWhoReacted(List<Long> usersWhoReacted) {
        this.usersWhoReacted = usersWhoReacted;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Publication(long PUBLICATION_ID, long AUTOR_ID, String text) {
        this.PUBLICATION_ID = PUBLICATION_ID;
        this.AUTOR_ID = AUTOR_ID;
        
        this.text = text;
        this.likes = 0;
        this.comments = new ArrayList();
        this.usersWhoReacted = new ArrayList();
        this.date = LocalDateTime.now();
    }

    public long getPUBLICATION_ID () {
        return this.PUBLICATION_ID;
    }

    public long getAUTOR_ID () {
        return this.AUTOR_ID;
    }

    public String getText () {
        return this.text;
    }

    public int getLikes () {
        return this.likes;
    }

    public List<Comment> getComments () {
        return this.comments;
    }

    public List<Long> getUsersWhoReacted () {
        return this.usersWhoReacted;
    }
    
    public void setPUBLICATION_ID(long id){
        this.PUBLICATION_ID = id;
    }
}
