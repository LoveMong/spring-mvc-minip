package com.spring.minip.board.dao;


import com.spring.minip.board.domain.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardDaoImpl implements BoardDao {

    @Autowired
    private SqlSession session;

    private static String namespace = "com.spring.minip.board.dao.BoardMapper.";


    @Override
    public void insertBoard(BoardDto boardDto) {
        session.insert(namespace + "insertBoard", boardDto);
    }

    @Override
    public List<BoardDto> boardList() {
        return session.selectList(namespace + "selectAll");
    }

    @Override
    public List<BoardDto> boardList(Map map) {
        return session.selectList(namespace + "selectPage", map);
    }

    @Override
    public int boardCount() {
        return session.selectOne(namespace + "countBoard");
    }

    @Override
    public BoardDto selectBoard(int board_num) {
        return session.selectOne(namespace + "selectBoard", board_num);
    }

    @Override
    public void deleteAll() {
        session.delete(namespace + "deleteAll");
    }
}
