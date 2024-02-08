package com.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanConversionTest {

    private RomanConversion r = new RomanConversion();

    @Test
    public void testRomanDecoder() {
        Assertions.assertEquals(593, r.romanDecoder("DXCIII"));
        Assertions.assertEquals(1399, r.romanDecoder("MCCCXCIX"));
        Assertions.assertEquals(1908, r.romanDecoder("MCMVIII"));
        Assertions.assertEquals(3999, r.romanDecoder("MMMCMXCIX"));
    }

    @Test
    public void testRomanConversionEnhanced() {
        Assertions.assertEquals("DXCIII", r.romanConversionEnhanced(593));
        Assertions.assertEquals("MCCCXCIX", r.romanConversionEnhanced(1399));
        Assertions.assertEquals("MCMVIII", r.romanConversionEnhanced(1908));
        Assertions.assertEquals("MMMCMXCIX", r.romanConversionEnhanced(3999));
    }

    @Test
    public void testRomanNumberConvertor() {
        Assertions.assertEquals("DXCIII", r.romanNumberConvertor(593));
        Assertions.assertEquals("MCCCXCIX", r.romanNumberConvertor(1399));
        Assertions.assertEquals("MCMVIII", r.romanNumberConvertor(1908));
        Assertions.assertEquals("MMMCMXCIX", r.romanNumberConvertor(3999));
    }

}
