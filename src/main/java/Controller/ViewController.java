/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.*;

/**
 *
 * @author USER
 */
public class ViewController {
    public static ViewController instance;
    public LoginView LOGINVIEW;
    public RegisterView REGISTERVIEW;
    
    private ViewController(){
        LOGINVIEW = LoginView.GetInstance();
        REGISTERVIEW = RegisterView.GetInstance();
    }
    public static ViewController GetInstance(){
        if(instance==null)instance = new ViewController();
        return instance;
    }
    
    public void StartFacUpdate(){
        LOGINVIEW.setVisible(true);
    }
    public void LoginToRegister(){
        LOGINVIEW.setVisible(false);
        REGISTERVIEW.setVisible(true);
    }
    public void RegisterToLogin(){
        REGISTERVIEW.setVisible(false);
        LOGINVIEW.setVisible(true);
    }
}
