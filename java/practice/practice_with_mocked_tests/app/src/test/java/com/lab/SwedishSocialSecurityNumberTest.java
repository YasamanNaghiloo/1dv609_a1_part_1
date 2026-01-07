package com.lab;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SwedishSocialSecurityNumberTest {
    
    private SSNHelper helper;
    
    @BeforeEach
    public void setUp() {
        helper = new SSNHelper();
    }

    @Test
    public void shouldAcceptValidSSN() throws Exception {
        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900101-0017", helper);
        
        assertEquals("90", ssn.getYear());
        assertEquals("01", ssn.getMonth());
        assertEquals("01", ssn.getDay());
        assertEquals("0017", ssn.getSerialNumber());
    }

    // buggy ssn helper allow day up to 30
    @Test
    public void helperReturnTrueValidDay() {
        assertTrue(helper.isValidDay("31"));
        assertTrue(helper.isValidDay("1"));
        assertTrue(helper.isValidDay("12"));
    }

    // buggy ssn helper allow month 0
    @Test
    public void helperReturnFalseInvalidMonth() {
        assertFalse(helper.isValidMonth("-1"));
        assertFalse(helper.isValidMonth("0"));
        assertFalse(helper.isValidMonth("13"));
    }

    // buggy ssn helper incorrect format false
    @Test
    public void helperReturnTrueFormatFalse() {
        assertTrue(helper.isCorrectFormat("900101-0017"));
        assertTrue(helper.isCorrectFormat("980124-1234"));
    }

    // buggy ssn helper incorrect format
    @Test
    public void helperReturnFalseIncorrectFormat() {
        assertFalse(helper.isCorrectFormat("90010.0017"));
        assertFalse(helper.isCorrectFormat("900100017"));
        assertFalse(helper.isCorrectFormat("123456/abcd"));
    }

    // buggy ssn helper messy luhn
    @Test
    public void helperShouldReturnTrueCorrectLuhn() {
        assertTrue(helper.luhnIsCorrect("900101-0017"));
    }

    // buggy ssn helper wrong length
    @Test
    public void helperShouldReturnFalseIncorrectLength() {
        assertFalse(helper.isCorrectLength("900101-1234567"));
        assertFalse(helper.isCorrectLength("9101-0"));
        assertFalse(helper.isCorrectLength("900101-17"));
    }

    // buggy swedish social security number no length check
    @Test
    public void shouldContainThrowLenException() throws Exception {
        SSNHelper ssnMock = mock(SSNHelper.class);

        when(ssnMock.isCorrectLength("900101-00017")).thenReturn(false);
        when(ssnMock.luhnIsCorrect("900101-00017")).thenReturn(true);
        when(ssnMock.isCorrectFormat("900101-00017")).thenReturn(true);
        when(ssnMock.isValidDay("01")).thenReturn(true);
        when(ssnMock.isValidMonth("01")).thenReturn(true);

        assertThrows(Exception.class, 
            () -> new SwedishSocialSecurityNumber("900101-00017", ssnMock));

        verify(ssnMock).isCorrectLength("900101-00017");
    }

    // buggy swedish social security number no luhn
    @Test
    public void shouldContainThrowLuhnException() throws Exception {
        SSNHelper ssnMock = mock(SSNHelper.class);

        when(ssnMock.luhnIsCorrect("900101-3429")).thenReturn(false);
        when(ssnMock.isCorrectLength("900101-3429")).thenReturn(true);
        when(ssnMock.isCorrectFormat("900101-3429")).thenReturn(true);
        when(ssnMock.isValidDay("01")).thenReturn(true);
        when(ssnMock.isValidMonth("01")).thenReturn(true);
        // 3429 isnt valid

        assertThrows(Exception.class, 
            () -> new SwedishSocialSecurityNumber("900101-3429", ssnMock));

        verify(ssnMock).luhnIsCorrect("900101-3429");
    }

    // buggy swedish social security number no trim
    @Test
    public void shouldContainThrowTrimException() throws Exception {
        SSNHelper ssnMock = mock(SSNHelper.class);

        when(ssnMock.isCorrectLength("900101-0017")).thenReturn(true);
        when(ssnMock.isCorrectFormat("900101-0017")).thenReturn(true);
        when(ssnMock.isValidDay("01")).thenReturn(true);
        when(ssnMock.isValidMonth("01")).thenReturn(true);
        when(ssnMock.luhnIsCorrect("900101-0017")).thenReturn(true);

        assertDoesNotThrow(() -> new SwedishSocialSecurityNumber("     900101-0017", ssnMock));

        verify(ssnMock).isCorrectFormat("900101-0017");
        // verifying isCorrectLength and LuhnIsCorrect will cause 2 other tests to fail wrongly,
        // as they dont have these method calls and therefore can't verify calling them
    }


    // buggy swedish social security number wrong year
    @Test
    public void shouldNotAllowWrongYear() throws Exception {
        SSNHelper ssnMock = mock(SSNHelper.class);

        when(ssnMock.isCorrectLength("900101-0017")).thenReturn(true);
        when(ssnMock.isCorrectFormat("900101-0017")).thenReturn(true);
        when(ssnMock.isValidMonth("01")).thenReturn(true);
        when(ssnMock.isValidDay("01")).thenReturn(true);
        when(ssnMock.luhnIsCorrect("900101-0017")).thenReturn(true);
        
        SwedishSocialSecurityNumber yearCheck = new SwedishSocialSecurityNumber("900101-0017", ssnMock);

        assertEquals("90", yearCheck.getYear());

        verify(ssnMock).isCorrectFormat("900101-0017");
        verify(ssnMock).isValidMonth("01");
        verify(ssnMock).isValidDay("01");
    }
}