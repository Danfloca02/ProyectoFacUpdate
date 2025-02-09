/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ingenieriadesoftware.facupdate.USER_CLASSES;


/**
 *
 * @author USER
 */



public abstract class User {
    
    public String userName;
    public long ID;
    public String Password;
    public String Email;
    public Career Kareer;
    
    public User(long id,String usernm, String email, String password, String caree){
        ID = id;
        userName = usernm;
        Password = password;
        Email = email;
        for(Career career : Career.values()){
            if(career.name().equals(caree)){
                Kareer = career;
                break;
            }
        }
    }
}

