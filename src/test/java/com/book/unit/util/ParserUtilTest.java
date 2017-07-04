//package com.book.unit.util;
//
//import com.book.unit.new_p.UnitTestConfiguration;
//import com.book.util.ParserUtil;
//import org.junit.Test;
//import static org.junit.Assert.assertEquals;
//
//public class ParserUtilTest extends UnitTestConfiguration{
//
//    @Test
//    public void shouldParsePhoneWithCode(){
//        String phone = ParserUtil.parsePhone("+48(922)-22 22");
//        assertEquals("9222222",phone);
//    }
//
//    @Test
//    public void shouldParsePhoneWithoutCode(){
//        String phone = ParserUtil.parsePhone("+(922)-22 22");
//        assertEquals("9222222",phone);
//    }
//}
