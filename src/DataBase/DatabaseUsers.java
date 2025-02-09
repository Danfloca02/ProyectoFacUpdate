/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ingenieriadesoftware.facupdate.DataBase;

/**
 *
 * @author CARLOS_MIRANDA
 */


import com.ingenieriadesoftware.facupdate.DataBase.FileGestor;
import com.ingenieriadesoftware.facupdate.USER_CLASSES.Teacher;
import java.io.IOException;
import java.util.Scanner;

//imports from proyect
import com.ingenieriadesoftware.facupdate.USER_CLASSES.User;
import com.ingenieriadesoftware.facupdate.USER_CLASSES.UserFactory;
import java.util.ArrayList;
import java.util.List;



//code:
public class DatabaseUsers {
    private static DatabaseUsers instance;
    private final UserFactory userFactory;
    private final FileGestor filegestor;
    private final String path;
    
    private DatabaseUsers(){
        filegestor = new FileGestor();
        userFactory = UserFactory.GetInstance();
        path = "./USERS.txt";
    }
    public static DatabaseUsers GetInstance(){
        if(instance == null){
            instance = new DatabaseUsers();
        }
        return instance;
    }
    public boolean createNewUser(User user){
        if(user == null){return false;}
        
        if(user instanceof Teacher){
            
        }
        return true;
    }
    
    
    //file structure:
    //ID UserType UserName email Password Career
    public User userSearchByID(long ID){
        String data = userSearch(String.valueOf(ID), "ID");
        if(data == null)return null;
        String[] parts = data.split(" ");
        User ret = userFactory.createUser(parts[1], Long.parseLong(parts[0]), parts[2], parts[3], parts[4], parts[5]);
        return ret;
    }
    public User userSearchByEMAIL(String EMAIL){
        String data = userSearch(EMAIL, "EMAIL");
        if(data == null)return null;
        String[] parts = data.split(" ");
        User ret = userFactory.createUser(parts[1], Long.parseLong(parts[0]), parts[2], parts[3], parts[4], parts[5]);
        return ret;
    }
    public User userSearchByUSERNAME(String USERNAME){
        String data = userSearch(USERNAME, "USERNAME");
        if(data == null)return null;
        String[] parts = data.split(" ");
        User ret = userFactory.createUser(parts[1], Long.parseLong(parts[0]), parts[2], parts[3], parts[4], parts[5]);
        return ret;
    }
    public List<User> getUserList(){
        List<User> ret = new ArrayList<>();
        
        try(Scanner br = filegestor.getScanner(path)){
            //file structure:
            //ID UserType UserName email Password Career
            while (br.hasNextLine()) {
                String line = br.nextLine();
                String[] parts = line.split(" ");
                ret.add(userFactory.createUser(parts[1], Long.parseLong(parts[0]), parts[2], parts[3], parts[4], parts[5]));
            }
        }catch (IOException e) {
            System.err.println("Esto no deberia fallar, y fallo");
        }
        return ret;
    }
    
    private String userSearch(String value, String type){
        try(Scanner br = filegestor.getScanner(path)){
            //file structure:
            //ID UserType UserName email Password Career
            while (br.hasNextLine()) {
                String line = br.nextLine();
                String[] parts = line.split(" ");
                switch(type){
                    case "ID":
                        if(Integer.parseInt(parts[0]) == Integer.parseInt(value)){
                            return line;
                        }
                    case "USERNAME":
                        if(value.equals(parts[2])){
                            return line;
                        }
                    case "EMAIL":
                        if(value.equals(parts[3])){
                            return line;
                        }
                        
                }
            }
        }catch (IOException e) {
            System.err.println("Esto no deberia fallar, y fallo");
        }
        return null;
    }
    
    
}
