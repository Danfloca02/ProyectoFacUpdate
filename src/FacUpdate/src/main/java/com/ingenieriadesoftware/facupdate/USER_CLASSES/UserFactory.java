/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ingenieriadesoftware.facupdate.USER_CLASSES;

/**
 *
 * @author USER
 */
public class UserFactory {
    private static UserFactory instance;
    
    private UserFactory(){
        
    }
    
    public static UserFactory GetInstance(){
        if(instance == null){
            instance = new UserFactory();
        }
        return instance;
    }
    public User createUser(String type, long id, String usernm,String email, String password, String caree){
        User ret;
        if(type.equals("TEACHER")){
            ret = new Teacher(id,usernm,email,password,caree);
        }
        else{
            ret = new Student(id,usernm,email,password,caree);
        }
        return ret;
    }
}
