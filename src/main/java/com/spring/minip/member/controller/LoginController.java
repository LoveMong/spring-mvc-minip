package com.spring.minip.member.controller;

import com.spring.minip.member.domain.MemberDto;
import com.spring.minip.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private MemberService memberService;


    @GetMapping("/login")
    public String loginFrom() {
        return "/user/loginForm";
    }

    @PostMapping("/login")
    public String login(String memberId, String memberPwd, String toUrl, boolean rememberId,
                        HttpServletRequest request, HttpServletResponse response) throws Exception {

//      1. 아이디와 패스워드 확인 (loginCheck)
        if (!loginCheck(memberId, memberPwd)) {
//          1-1. 아이디와 패스워드가 일치하지 않으면 그 내용을 message에 담에 login 페이지로 redirect
            String message = URLEncoder.encode("아이디 또는 패스워드가 일치하지 않습니다.", "utf-8");
            return "redirect:/login/login?message=" + message;
        }
//      2. 아이디와 패스워드가 일치하면
//      2-1. 세션 얻어오기
        HttpSession session = request.getSession();
//      2-2. 세션에 memberId 저장
        session.setAttribute("memberId", memberId);

//      3. 로그인 화면 아이디 기억하기 check 유무에 따른 쿠키 저장 및 삭제
        if (rememberId) {
//      3-1. 아이디 기억하기 체크가 되어있다면 쿠키 생성 및 응답에 저장
            Cookie cookie = new Cookie("memberId", memberId);
            response.addCookie(cookie);
        } else {
//      3-2. 아이디 기억하기 체크가 되어있지 않다면 쿠키 삭제 및 응답에 저장
            Cookie cookie = new Cookie("memberId", memberId);
            cookie.setMaxAge(0); // 쿠키 삭제
            response.addCookie(cookie);
        }
//      * 사용자 편의를 위한 경로 추적
        toUrl = toUrl == null && toUrl.equals("") ? "/" : toUrl;

        return "redirect:" + toUrl;

    }

    private boolean loginCheck(String memberId, String memberPwd) {

        MemberDto memberDto = null;

        try {
            memberDto = memberService.login(memberId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return memberDto != null && memberDto.getMember_pwd().equals(memberPwd);
    }

}
