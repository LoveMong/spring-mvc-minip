package com.spring.minip.board.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml", "file:src/main/webapp/WEB-INF/spring/**/spring-security.xml"})
@Slf4j
public class PageHandlerTest {
    
    @Test
    public void test () throws Exception {
        //given
        PageHandler pageHandler = new PageHandler(250, 1);
        pageHandler.print();
        //when
        
        
        //then
       assertTrue(pageHandler.getBeginPage() == 1);
       assertTrue(pageHandler.getEndPage() == 10);
       
    }

    @Test
    public void test2 () throws Exception {
        //given
        PageHandler pageHandler = new PageHandler(250, 11);
        pageHandler.print();
        log.info("pageHandler = " + pageHandler);
        //when


        //then
        assertTrue(pageHandler.getBeginPage() == 11);
        assertTrue(pageHandler.getEndPage() == 20);

    }

    @Test
    public void test3 () throws Exception {
        //given
        PageHandler pageHandler = new PageHandler(255, 25);
        pageHandler.print();
        log.info("pageHandler = " + pageHandler);

        //when


        //then
        assertTrue(pageHandler.getBeginPage() == 21);
        assertTrue(pageHandler.getEndPage() == 26);

    }


        

}