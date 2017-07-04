//package com.book.unit;
//
//import org.junit.Test;
//import org.mockito.InjectMocks;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//public class PhoneNumberServiceTest extends OlxParserTest {
//    private static final String NORWAY_PHONE = "07000";
//    private static final String CHINA_PHONE = "003000";
//    private static final String NORWAY_CODE = "070";
//
//    @InjectMocks
//    private PhoneNumberServiceImpl numberService;
//
//    @Test
//    public void shouldTestPersonWithNorwayPhoneNumber() {
//        assertTrue(numberService.isNumberBelongToCountry(NORWAY_PHONE, NORWAY_CODE));
//    }
//
//    @Test
//    public void shouldTestPersonWithChinaPhoneNumber() {
//        assertFalse(numberService.isNumberBelongToCountry(CHINA_PHONE, NORWAY_CODE));
//    }
//
//}
