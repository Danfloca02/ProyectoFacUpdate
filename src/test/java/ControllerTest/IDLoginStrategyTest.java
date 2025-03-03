package ControllerTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import Controller.session.IDLoginStrategy;
import Controller.session.LoginStrategy;

public class IDLoginStrategyTest {
    LoginStrategy ls = new IDLoginStrategy();

    @Test
    public void autenthicateUserExistsValidAndCorrectPasswordTest(){
        assertTrue(ls.authenticate("31080238", "Carlos.11")); //Evaluate an actual user
    }

    @Test
    public void autenthicateUserExistsValidButIncorrectPasswordTest(){
        assertFalse(ls.authenticate("31080238", "Carlos.12")); //Evaluate an actual user given the wrong password
    }

    @Test
    public void autenthicateUserExistsInvalidPasswordTest(){
        assertFalse(ls.authenticate("31080238", "1588")); //Evaluate an actual user but given an Invalid Password
    }

    @Test
    public void autenthicateNonExistentUserTest(){
        assertFalse(ls.authenticate("55584847", "Carlos.11")); //Evaluate a non-existent student
    }
    
}
