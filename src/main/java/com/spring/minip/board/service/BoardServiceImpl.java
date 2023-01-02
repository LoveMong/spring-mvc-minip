package com.spring.minip.board.service;

import com.spring.minip.board.dao.BoardDao;
import com.spring.minip.board.domain.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDao boardDao;

    @Override
    public List<BoardDto> boardList() throws Exception {
        return boardDao.boardList();
    }

    @Override
    public List<BoardDto> boardList(Map map) throws Exception {
        return boardDao.boardList(map);
    }

    @Override
    public int boardCount() throws Exception {
        return boardDao.boardCount();
    }

    @Override
    public BoardDto boardContent(int board_num) throws Exception {
        BoardDto boardDto = boardDao.selectBoard(board_num);
        boardDao.increaseHits(board_num);

        return boardDto;
    }

    @Override
    public void boardRegister(BoardDto boardDto) throws Exception {
        boardDao.insertBoard(boardDto);
    }

    @Override
    public void boardDelete(int board_num) throws Exception {
        boardDao.deleteSelect(board_num);
    }

    @Override
    public String boardCheckPass(int board_num) throws Exception {
        return boardDao.selectBoardPass(board_num);
    }
    
    @Override
    public void boardUpdate(BoardDto boardDto) throws Exception {
        boardDao.boardUpdate(boardDto);
    }
    
    
    
    

}
