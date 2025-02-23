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



public class Publication {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Publication{");
        sb.append("PUBLICATION_ID=").append(PUBLICATION_ID);
        sb.append(", AUTOR_ID=").append(AUTOR_ID);
        sb.append(", text=").append(text);
        sb.append(", likes=").append(likes);
        sb.append(", date=").append(date.toString());
        sb.append(", image_path=").append(image_path);
        sb.append('}');
        return sb.toString();
    }

    
    private long PUBLICATION_ID;
    private long AUTOR_ID;
    
    private String text;
    private int likes;
    private List<Comment> comments;
    private List<Long> usersWhoReacted;
    private LocalDateTime date;
    private String image_path;
    
    public Publication(long PUBLICATION_ID, long AUTOR_ID, String text, String image_path) {
        this.PUBLICATION_ID = PUBLICATION_ID;
        this.AUTOR_ID = AUTOR_ID;
        this.image_path = image_path;
        this.text = text;
        this.likes = 0;
        this.comments = new ArrayList();
        this.usersWhoReacted = new ArrayList();
        this.date = LocalDateTime.now();
    }
    public Publication(long PUBLICATION_ID, long AUTOR_ID, String text, String image_path, int likes, List<Comment> comentarios, List<Long> uwr, LocalDateTime date) {
        this.PUBLICATION_ID = PUBLICATION_ID;
        this.AUTOR_ID = AUTOR_ID;
        this.image_path = image_path;
        this.text = text;
        this.likes = likes;
        this.comments = comentarios;
        this.usersWhoReacted = uwr;
        this.date = date;
    }
    public Publication(){
        this.PUBLICATION_ID = 0;
        this.AUTOR_ID = 0;
        this.image_path = "";
        this.text = "";
        this.likes = 0;
        this.comments = new ArrayList();
        this.usersWhoReacted = new ArrayList();
        this.date = LocalDateTime.now();
    }
    
    
    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
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
        this.likes = usersWhoReacted.size();
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setPUBLICATION_ID(long id){
        this.PUBLICATION_ID = id;
    }
    
    public String getImage_path() {
        return image_path;
    }
    public long getPUBLICATION_ID () {
        return this.PUBLICATION_ID;
    }
    public LocalDateTime getDate() {
        return date;
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
    
    
}
