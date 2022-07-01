package com.spring.minip.board.controller;


import com.spring.minip.board.domain.BoardDto;
import com.spring.minip.board.domain.PageHandler;
import com.spring.minip.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 게시판 기능 컨트롤을 위한 클래스
 * @Project : spring-minip
 * @Date : 2022-06-30
 * @Author : L
 */
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    /**
     * 게시판의 게시글들을 DB로 부터 불러와 페이징 작업 후 클라이언트로 return
     * @param page 클라이언트로부터 요청 받은 매개변수(default 1)
     * @param pageSize 클라이언트로부터 요청 받은 매개변수(default 10)
     * @param m 게시판 글 목록 객체, 페이징 설정 객체을 담은 객체
     * @return 게시판 리스트(boardList.jsp) 페이지로 return
     * @throws Exception
     */
    @GetMapping("/list")
    public String boardList(@RequestParam(value = "page", defaultValue = "1") int page,
                            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, Model m) throws Exception {

        Map map = new HashMap();
        map.put("offset", (page - 1) * pageSize);
        map.put("pageSize", pageSize);

        int totalCnt = boardService.boardCount();
        PageHandler pageHandler = new PageHandler(totalCnt, page, pageSize);

        List<BoardDto> boardDto = boardService.boardList(map);
        m.addAttribute("boardList", boardDto);
        m.addAttribute("ph", pageHandler);

        return "/board/boardList";

    }

    @GetMapping("/content")
    public String boardContent(int board_num, Model m) throws Exception{

        BoardDto boardDto = boardService.boardContent(board_num);

        m.addAttribute("board", boardDto);

        return "board/boardContent";
    }
}
