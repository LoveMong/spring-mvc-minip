package com.spring.minip.board.dao;

import com.spring.minip.board.domain.BoardDto;

import java.util.List;
import java.util.Map;

public interface BoardDao {
    void insertBoard(BoardDto boardDto);

    List<BoardDto> boardList();

    List<BoardDto> boardList(Map map);

    int boardCount();

    BoardDto selectBoard(int board_num);

    void deleteAll();
}