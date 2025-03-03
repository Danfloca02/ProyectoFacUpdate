package ControllerTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import Controller.session.LoginStrategy;
import Controller.session.UsernameLoginStrategy;

public class UsernameLoginStrategyTest{ 
    LoginStrategy ls = new UsernameLoginStrategy();

    @Test
    public void autenthicateUserExistsValidAndCorrectPasswordTest(){
        assertTrue(ls.authenticate("Carlos_11", "Carlos.11")); //Evaluate an actual user
    }

    @Test
    public void autenthicateUserExistsValidButIncorrectPasswordTest(){
        assertFalse(ls.authenticate("Carlos_11", "Carlos.12")); //Evaluate an actual user given the wrong password
    }

    @Test
    public void autenthicateUserExistsInvalidPasswordTest(){
        assertFalse(ls.authenticate("Carlos_11", "1588")); //Evaluate an actual user but given an Invalid Password
    }

    @Test
    public void autenthicateNonExistentUserTest(){
        assertFalse(ls.authenticate("Carlos_15", "Carlos.11")); //Evaluate a non-existent student
    }
}