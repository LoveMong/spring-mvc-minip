package com.spring.minip.board.dao;

import com.spring.minip.board.domain.BoardDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml", "file:src/main/webapp/WEB-INF/spring/**/spring-security.xml"})
@Slf4j
public class BoardDaoImplTest {

    @Autowired
    private BoardDaoImpl boardDao;

    @Test
    public void insertBoard() throws Exception {
        //given
        boardDao.deleteAll();

        for(int i = 0; i < 180; i++){
            BoardDto boardDto = BoardDto.builder()
                    .board_title("Test" + i)
                    .board_writer("TestWriter" + i)
                    .board_content("Korea is a peninsular region in East Asia. Since 1945," +
                            "it has been divided between two countries at or near the 38th parallel,")
                    .build();

            boardDao.insertBoard(boardDto);
        }

        //when
        List<BoardDto> boardDtos = boardDao.boardList();


        //then
       assertNotNull(boardDtos);

    }


    @Test
    public void selectAll () throws Exception {
        //given
        BoardDto boardDto = BoardDto.builder()
                .board_title("Test")
                .board_writer("TestWriter")
                .build();
        boardDao.insertBoard(boardDto);

        //when
        List<BoardDto> boardDto1 = boardDao.boardList();
        log.info("boardDto1" + boardDto1);

        //then
        assertNotNull(boardDto1);

    }

    @Test
    public void increaseHits() throws Exception {
        //given
        boardDao.deleteAll();

        for(int i = 0; i < 5; i++){
            BoardDto boardDto = BoardDto.builder()
                    .board_title("Test" + i)
                    .board_writer("TestWriter" + i)
                    .board_content("Korea is a peninsular region in East Asia. Since 1945," +
                            "it has been divided between two countries at or near the 38th parallel,")
                    .build();

            boardDao.insertBoard(boardDto);
        }

        //when
        boardDao.increaseHits(1);
        BoardDto boardDto1 = boardDao.selectBoard(1);
        //then
       assertEquals(boardDto1.getBoard_hits(), 1);





    }



}