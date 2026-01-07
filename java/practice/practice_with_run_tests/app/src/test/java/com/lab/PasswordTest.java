package com.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Test class for Password implementations.
 * 
 * To test different buggy versions, simply uncomment the corresponding
 * getPassword() method and comment out the others.
 * 
 * Available implementations:
 * - Password: Correct implementation
 * - BugDoesNotTrim: Does not trim whitespace
 * - BugToShortPassword: Allows passwords shorter than 12 characters
 * - BugVeryShort: Allows way to short passwords
 * - BugWrongExceptionMessage: Wrong exception message for short passwords
 * - BugMissingPasswordLengthCheck: Does not throw exception for short passwords
 * - BugMissingNumberCheck: Does not throw exception if password lacks a number
 * - BugIsPasswordSameAlwaysTrue: isPasswordSame always returns true
 * - BugWrongHashingAlgorithm: Wrong hashing algorithm
 */

public class PasswordTest {
    private IPassword getPassword(String s) throws Exception {
        // return (IPassword) new Password(s);
        // return (IPassword) new BugDoesNotTrim(s);
        // return (IPassword) new BugToShortPassword(s);
        // return (IPassword) new BugVeryShort(s);
        // return (IPassword) new BugWrongExceptionMessage(s);
        // return (IPassword) new BugMissingPasswordLengthCheck(s);
        // return (IPassword) new BugMissingNumberCheck(s);
        // return (IPassword) new BugIsPasswordSameAlwaysTrue(s);
        // return (IPassword) new BugWrongHashingAlgorithm(s);
    }

    @Test
    public void shouldAlwaysPass() throws Exception {
        assertTrue(true);
    }

    @Test 
    public void constructorShouldTrimWhiteSpacesForPasswordWithSpaces() throws Exception {
        IPassword pw1 = getPassword("longPassword123");
        IPassword pw2 = getPassword("  longPassword123  ");
        assertTrue(pw1.isPasswordSame(pw2));
    }

    @Test
    public void constructorShouldNotAllowShortPasswords() {
        assertThrows(Exception.class, () -> getPassword("Password123"));
    }

    @Test
    public void constructorShouldNotAllowVeryShortPasswords() {
        assertThrows(Exception.class, () -> getPassword("Short1"));
    }

    @Test
    public void constructorShouldHaveCorrectExceptionMessage() throws Exception {
        
        Exception e1 = assertThrows(Exception.class, () -> getPassword("opps1"));
        assertEquals("To short password", e1.getMessage());
    }

    @Test
    public void constructorShouldCheckForNumber() throws Exception {
        assertThrows(Exception.class, () -> getPassword("longpassword"));
    }

    @Test
    public void isPasswordSameShouldBeFalseWithDiefferentPasswords() throws Exception {
        IPassword pw1 = getPassword("longPassword123");
        IPassword pw2 = getPassword("longPassword124");
        assertFalse(pw1.isPasswordSame(pw2), "isPasswordSame() Should Return False");
    }


    @Test 
    public void differentPasswordShouldNotBeTheSame() throws Exception {
        IPassword pw1 = getPassword("Password1234");
        IPassword pw2 = getPassword("Password1239");

        assertFalse(pw1.isPasswordSame(pw2));

    }

    
    // @Test
    // public void diffrentPasswordShouldNotBeTheSame() throws Exception {
    //     IPassword pw1 = getPassword("Password0001");
    //     IPassword pw2 = getPassword("Password0002");
    //     IPassword pw3 = getPassword("Password0003");
    //     IPassword pw4 = getPassword("Password0004");
    //     IPassword pw5 = getPassword("Password0005");
    //     IPassword pw6 = getPassword("Password0006");

    //     IPassword[] passwords = {pw1, pw2, pw3, pw4, pw5, pw6};
    //     for (int i = 0; i < passwords.length; i++) {
    //         for (int j = i + 1; j < passwords.length; j++) {
    //             assertFalse(passwords[i].isPasswordSame(passwords[j]),
    //             "Different passwords must not be considered equal: " + i + "and" + j);
    //         }
    //     }
        
    // }


}
