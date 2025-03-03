
import Controller.StringValidator;
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
public class StringValidatorTest {
    public static void main(String[] args) {
        
        User user = UserFactory.createUser("STUDENT", 14861479, "Yarlinbrito", "yarlinbrito@gmail.com", "Yarlin.123", "COMPUTACION");
        System.out.println(StringValidator.validateEmail(user.Email));
        System.out.println(StringValidator.validatePassword(user.Password));
        System.out.println(StringValidator.validateUsername(user.userName));
        System.out.println(StringValidator.validateIDcard(Long.toString(user.ID)));
        
    }
}
