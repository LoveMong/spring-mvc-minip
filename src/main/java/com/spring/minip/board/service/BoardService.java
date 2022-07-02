package com.spring.minip.board.service;

import com.spring.minip.board.domain.BoardDto;

import java.util.List;
import java.util.Map;

public interface BoardService {
    List<BoardDto> boardList() throws Exception;

    List<BoardDto> boardList(Map map) throws Exception;

    int boardCount() throws Exception;

    BoardDto boardContent(int board_num) throws Exception;

    void boardRegister(BoardDto boardDto) throws Exception;
}
