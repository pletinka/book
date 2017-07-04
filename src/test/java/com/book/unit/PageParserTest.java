//package com.book.unit;
//
//import com.book.model.SourceUrl;
//import com.book.service.olx.impl.OlxParserImpl;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//public class PageParserTest {
//
//    @InjectMocks
//    private OlxParserImpl olxParser;
//    private String
//        pageUrl = "https://www.olx.pl/nieruchomosci/mieszkania/wynajem/krakow/?search%5Bprivate_business%5D=business";
//    @Test
//    public void shouldParsePage() {
//        SourceUrl sourceUrl = new SourceUrl();
//        sourceUrl.setUrl(pageUrl);
//        olxParser.parsePage(sourceUrl);
//    }
//
//}
