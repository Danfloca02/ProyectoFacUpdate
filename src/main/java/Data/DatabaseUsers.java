package Data;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author CARLOS_MIRANDA
 */



import Model.Teacher;
import Model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import Model.UserFactory;
import java.io.BufferedWriter;



//code:
public class DatabaseUsers {
    private static DatabaseUsers instance;
    private static FileGestor filegestor;
    private static String path;
    
    private DatabaseUsers(){
        filegestor = new FileGestor();
        
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
        
        User a = userSearchByID(user.ID);
        if(a == null){
            StringBuilder niuUser = new StringBuilder();
            niuUser.append(user.ID);
            niuUser.append(" ");
            if(user instanceof Teacher){
                niuUser.append("TEACHER");
            }
            else{
                niuUser.append("STUDENT");
            }
            niuUser.append(" ");
            niuUser.append(user.userName);
            niuUser.append(" ");
            niuUser.append(user.Email);
            niuUser.append(" ");
            niuUser.append(user.Password);
            niuUser.append(" ");
            niuUser.append(user.Kareer.name());
            
            String newUser = niuUser.toString();
            
            try(BufferedWriter bw = filegestor.getBufferedWriter(path, true)){
                bw.write(newUser);
                bw.newLine();
            }catch(IOException e){
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
    
    
    //file structure:
    //ID UserType UserName email Password Career
    public User userSearchByID(long ID){
        String data = userSearch(String.valueOf(ID), "ID");
        if(data == null)return null;
        String[] parts = data.split(" ");
        User ret = UserFactory.createUser(parts[1], Long.parseLong(parts[0]), parts[2], parts[3], parts[4], parts[5]);
        return ret;
    }
    public User userSearchByEMAIL(String EMAIL){
        String data = userSearch(EMAIL, "EMAIL");
        if(data == null)return null;
        String[] parts = data.split(" ");
        User ret = UserFactory.createUser(parts[1], Long.parseLong(parts[0]), parts[2], parts[3], parts[4], parts[5]);
        return ret;
    }
    public User userSearchByUSERNAME(String USERNAME){
        String data = userSearch(USERNAME, "USERNAME");
        if(data == null)return null;
        String[] parts = data.split(" ");
        User ret = UserFactory.createUser(parts[1], Long.parseLong(parts[0]), parts[2], parts[3], parts[4], parts[5]);
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
                ret.add(UserFactory.createUser(parts[1], Long.parseLong(parts[0]), parts[2], parts[3], parts[4], parts[5]));
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
