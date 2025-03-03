/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Publication;
import View.*;

/**
 *
 * @author USER
 */
public class ViewController {
    private static ViewController instance;
    public LoginView LOGINVIEW;
    public RegisterView REGISTERVIEW;
    public PrincipalFeed PRINCIPALFEED;
    public CreatePublicationView CREATEPUBLICATION;
    public UserView USERVIEW;
    
    private ViewController(){
        LOGINVIEW = LoginView.GetInstance();
        REGISTERVIEW = RegisterView.GetInstance();
        PRINCIPALFEED = PrincipalFeed.GetInstance();
        USERVIEW = UserView.GetInstance();
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
    public void LoginToPrincipalFeed(){
        LOGINVIEW.setVisible(false);
        PRINCIPALFEED.OpenFeed();
        PRINCIPALFEED.setVisible(true);
    }
    public void PrincipalFeedToLogin(){
        PRINCIPALFEED.setVisible(false);
        LOGINVIEW.ClearFields();
        LOGINVIEW.setVisible(true);
    }
    public void OpenCreatePublication(){
        CREATEPUBLICATION = new CreatePublicationView();
        CREATEPUBLICATION.setVisible(true);
    }
    public comentView OpenCommentsView(Publication p){
        comentView cv = new comentView();
        cv.setPublication(p);
        cv.setVisible(true);
        return cv;
    }
    public void UserToFeed(){
        USERVIEW.setVisible(false);
        PRINCIPALFEED.OpenFeed();
        PRINCIPALFEED.setVisible(true);
    }
    public void FeedToUser(){
        PRINCIPALFEED.setVisible(false);
        USERVIEW.load();
        USERVIEW.setVisible(true);  
    }
    public void UserToLogin(){
        USERVIEW.setVisible(false);
        LOGINVIEW.ClearFields();
        LOGINVIEW.setVisible(true);
    }
}
