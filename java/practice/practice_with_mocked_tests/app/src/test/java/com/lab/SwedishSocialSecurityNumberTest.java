package com.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SwedishSocialSecurityNumberTest {
    
    private SSNHelper helper;
    
    @BeforeEach
    public void setUp() {
        helper = new SSNHelper();
    }
    
    @Test
    public void shouldAcceptValidSSN() throws Exception {
        when(mockHelper.isCorrectLength("900101-0017")).thenReturn(true);
        when(mockHelper.isCorrectFormat("900101-0017")).thenReturn(true);
        when(mockHelper.isValidMonth("01")).thenReturn(true);
        when(mockHelper.isValidDay("01")).thenReturn(true);
        when(mockHelper.luhnIsCorrect("900101-0017")).thenReturn(true);
        
        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900101-0017", helper);
        
        assertEquals("90", ssn.getYear());
        assertEquals("01", ssn.getMonth());
        assertEquals("01", ssn.getDay());
        assertEquals("0017", ssn.getSerialNumber());
    }

    @Test
    public void 

    //Buggy helper tests
    @Test
    public void shouldReturnFalseForInvalidDay() throws Exception {
        assertFalse(helper.isValidDay("32"));

    }

    @Test
    public void shouldReturnFalseForInvalidMonth() throws Exception {
        assertFalse(helper.isValidMonth("0"));
    }

    @Test
    public void shouldCheckIncorrectFormat() throws Exception {
        assertFalse(helper.isCorrectFormat("900101-017"));
    }


    @Test
    public void shouldReturnTrueForCorrectFormat() throws Exception {
        assertTrue(helper.isCorrectFormat("900101-0017"));
    }

    @Test
    public void shouldCheckLength() throws Exception {
        assertTrue(helper.isCorrectLength("900101-0017"));
    }

    @Test
    public void shouldAcceptValidLuhn() throws Exception {
        assertTrue(helper.luhnIsCorrect("900101-0017"));
    }
}