package ControllerTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import Controller.StringValidator;

public class StringValidatorTest {
    StringValidator sv;
    
    @Test
    public void validateEmailTest(){
        assertTrue(sv.validateEmail("danfloca02@gmail.com"));
        assertFalse(sv.validateEmail("danfloca02#gmail.com"));
    }

    @Test
    public void validateUsernameTest(){
        assertTrue(sv.validateUsername("Danfloca02"));
        assertFalse(sv.validateUsername("$Danfloca02"));
    }

    @Test
    public void validatePasswordTest(){
        assertTrue(sv.validatePassword("Dan2307"));
        assertFalse(sv.validatePassword("2307"));
    }

    @Test
    public void validateIDcardTest(){
        assertTrue(sv.validateIDcard("28314837"));
        assertFalse(sv.validateIDcard("00000000"));
        assertFalse(sv.validateIDcard("1245444p"));
    }

}
