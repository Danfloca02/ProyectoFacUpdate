package Controller.session;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */

import Controller.StringValidator;
import Data.DatabaseUsers;
import Model.UserFactory;


        
public class SesionController {
    static SesionController instance;
    static DatabaseUsers DB;
    
    private SesionController(){
        DB = DatabaseUsers.GetInstance();
    }
    
    public static SesionController GetInstance(){
        if(instance == null){
            instance = new SesionController();
        }
        return instance;
    }
    
    public boolean login(String data, String password){
        
        LoginStrategy strategy = null;
        
        if (StringValidator.validateIDcard(data)) {
            strategy = new IDLoginStrategy();
        }
    
        else if (StringValidator.validateUsername(data)) {
            strategy = new UsernameLoginStrategy();
        }
        else if (StringValidator.validateEmail(data)) {
            strategy = new EmailLoginStrategy();     
        }
        
        if(strategy == null){
            return false;
        }
        return strategy.authenticate(data, password);
    }
    public boolean register(String AccountType, String Email, String Password, String ID, String Username){
        
        if(!StringValidator.validateEmail(Email))return false;
        if(!StringValidator.validatePassword(Password))return false;
        if(!StringValidator.validateIDcard(ID))return false;
        if(!StringValidator.validateUsername(Username))return false;
        
        return DB.createNewUser(UserFactory.createUser(AccountType.toUpperCase(), Long.parseLong(ID), Username, Email, Password, "COMPUTACION"));
    }
}
