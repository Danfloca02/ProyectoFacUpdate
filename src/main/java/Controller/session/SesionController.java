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
import Model.User;
import Model.UserFactory;


        
public class SesionController {
    private static SesionController instance;
    private static DatabaseUsers DB;
    public User ActualSession;
    
    private SesionController(){
        DB = DatabaseUsers.GetInstance();
        ActualSession = null;
    }
    
    
    public static SesionController GetInstance(){
        if(instance == null){
            instance = new SesionController();
        }
        return instance;
    }
    public User SearchUserByID(Long id){
        return DB.userSearchByID(id);
    }
    public void CloseSession(){
        ActualSession = null;
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
        boolean log =  strategy.authenticate(data, password);
        if(log){
            if (strategy instanceof IDLoginStrategy) {
                ActualSession = DB.userSearchByID(Long.parseLong(data));
            } else if (strategy instanceof UsernameLoginStrategy) {
                ActualSession = DB.userSearchByUSERNAME(data);
            } else if (strategy instanceof EmailLoginStrategy) {
                ActualSession = DB.userSearchByEMAIL(data);
            }
            return true;
        }
        return false;
    }
    public boolean register(String AccountType, String Email, String Password, String ID, String Username){
        
        if(!StringValidator.validateEmail(Email))return false;
        if(!StringValidator.validatePassword(Password))return false;
        if(!StringValidator.validateIDcard(ID))return false;
        if(!StringValidator.validateUsername(Username))return false;
        
        return DB.createNewUser(UserFactory.createUser(AccountType.toUpperCase(), Long.parseLong(ID), Username, Email, Password, "COMPUTACION"));
    }
}
