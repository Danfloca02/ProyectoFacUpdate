
import Controller.session.SesionController;
import Model.User;
import Model.UserFactory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
public class SessionControllerTest {
    static SesionController test = SesionController.GetInstance();
    public static void main(String[] args) {
        User a = UserFactory.createUser("STUDENT", 31080238, "CARLOS_11", "Carlos@gmail.com", "Carlos.11", "COMPUTACION");
        System.out.println(loginTest(Long.toString(a.ID), a.Password));
        System.out.println(loginTest(a.Email,a.Password));
        System.out.println(loginTest(a.userName,a.Password));
        
        System.out.println(registerTest(a.getClass().getTypeName().toUpperCase(), a.Email, a.Password, Long.toString(a.ID), a.userName));
        System.out.println(registerTest(a.getClass().getTypeName().toUpperCase(), a.Email, a.Password, Long.toString(a.ID), a.userName));
        System.out.println(loginTest(Long.toString(a.ID), a.Password));
        System.out.println(loginTest(a.Email,a.Password));
        System.out.println(loginTest(a.userName,a.Password));
        
        System.out.println(loginTest(a.userName,a.Password + "pruebadecontrasenia"));
        System.out.println(loginTest(a.userName + "pruebadedatoincorrecto",a.Password));
        
    }
    
    private static boolean loginTest(String Data, String Password){
        return test.login(Data, Password);
    }
    private static boolean registerTest(String AccountType, String Email, String Password, String ID, String Username){
        return test.register(AccountType, Email, Password, ID, Username);
    }
    
}
