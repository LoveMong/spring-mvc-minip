package com.spring.minip.board.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.minip.board.domain.BoardDto;
import com.spring.minip.board.domain.PageHandler;
import com.spring.minip.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

/**
 * 게시판 기능 컨트롤을 위한 클래스
 *
 * @Project : spring-minip
 * @Date : 2022-06-30
 * @Author : L
 */
@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    /**
     * 게시판의 게시글들을 DB로 부터 불러와 페이징 작업 후 클라이언트로 return
     *
     * @param page     클라이언트로부터 요청 받은 매개변수(default 1)
     * @param pageSize 클라이언트로부터 요청 받은 매개변수(default 10)
     * @param m        게시판 글 목록 객체, 페이징 설정 객체을 담은 객체
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

    /**
     * 선택된 게시글 상세 페이지 메소드
     *
     * @param board_num 선택된 게시글 번호 매개변수
     * @param m         게시글 번호에 해당되는 상세 내역을 담는 객체
     * @return 게시글 상세 페이지(boardContent.jsp)로 이동
     * @throws Exception
     */
    @GetMapping("/content")
    public String boardContent(int board_num, Model m) throws Exception {

        BoardDto boardDto = boardService.boardContent(board_num);

        m.addAttribute("board", boardDto);

        return "board/boardContent";
    }

    /**
     * 게시글 등록 페이지로 이동 메소드
     *
     * @return 게시글 페이지(boardRegister.jsp)로 이동
     */
    @GetMapping("/register")
    public String boardRegister() {
        return "board/boardRegister";
    }

    /**
     * 게시글 등록
     *
     * @param boardDto 게시글 상세 정보(board_num, board_title, board_content...를 담은 객체
     * @return 게시글 리스트(board/list)로 redirect
     * @throws Exception
     */
    @PostMapping("/register")
    public String boardRegister(BoardDto boardDto) throws Exception {
        boardService.boardRegister(boardDto);
        return "redirect:/board/list";
    }


    /**
     * 게시판 수정 시 게시물 비밀번호 확인 페이지로 이동 메소드
     *
     * @param board_num 삭제 요청된 게시물 번호 매개변수
     * @param m         해당 게시물 번호를 담은 객체
     * @return 게시물 번호 확인 페이지(boardCheckPass.jsp)로 이동
     */
    @GetMapping("/checkPassword")
    public String checkPassword(@RequestParam("num") int board_num, Model m) {
        m.addAttribute("num", board_num);
        return "board/boardCheckPass";
    }

    @GetMapping("/checkPassSuccess")
    public String checkPassSuccess(@RequestParam("num") int board_num, Model m) {
        log.info("board_num : " + board_num);
        m.addAttribute("num", board_num);
        return "board/boardCheckSuccess";
    }

    /**
     * 게시글 삭제 처리 메소드
     * @param board_num 해당 게시글 번호
     * @param content_password 해당 게시글 비밀번호
     * @return ajaxResult 삭제 성공 시 1 반환
     * @throws Exception
     */
    @PostMapping("/checkPassword")
    public String checkPassword(@RequestParam("num") int board_num,
                                @RequestParam("pass") String content_password, Model m) throws Exception {

        log.info("num : " + board_num);
        log.info("pass : " + content_password);

        if (!checkPass(board_num, content_password)) {
            m.addAttribute("message", "비밀번호를 확인해주세요.");
            return "board/boardCheckPass";
        } else {
            return "board/boardCheckSuccess";
        }

    }

    @GetMapping("/delete")
    public void boardDelete(@RequestParam("num") int board_num) throws Exception {
        boardService.boardDelete(board_num);
    }

    @GetMapping("/update")
    public String boardUpdate(@RequestParam("num") int board_num, Model model) throws Exception {

        BoardDto boardDto = boardService.boardContent(board_num);
        model.addAttribute("board", boardDto);
        return "board/boardUpdate";
    }
    
    @PostMapping("/update")
    public String boardUpdate(BoardDto boardDto) throws Exception {
    	
    	boardService.boardUpdate(boardDto);
    	
    	return "redirect:/board/list";
    }

    /**
     * 게시판 게시글 수정, 삭제 시 비밀번호 확인 메소드
     *
     * @param board_num 해당 게시판 번호
     * @param content_password 게시글 비밀번호
     * @return 비밀번호 확인, 일치 시 true 아니면 false 반환
     * @throws Exception
     */
    private boolean checkPass(int board_num, String content_password) throws Exception {
        String checkPass = boardService.boardCheckPass(board_num);
        return checkPass.equals(content_password);
    }

}
