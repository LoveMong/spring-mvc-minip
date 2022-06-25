package com.spring.minip.member.controller;

import com.spring.minip.member.domain.MemberDto;
import com.spring.minip.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
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
import java.nio.charset.StandardCharsets;

/**
 *  로그인 기능 컨트롤을 위한 클래스 *
 * @Project : spring-minip
 * @Date : 2022-06-09
 * @Author : L
 */
@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private MemberService memberService;

    /**
     * Get 방식 요청 Url(/login)에 대한 view return(loginForm) 메소드
     * @return login.jsp
     */
    @GetMapping("/login")
    public String loginFrom() {
        return "/member/loginForm";
    }

    /**
     * 로그아웃 처리 메소드
     * @param session 요청자 정보관리 HttpSession
     * @return 메인페이지로 리다이렉트
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
//      1. 세션 종료
        session.invalidate();
//      2. 메인 페이지로 이동
        return "redirect:/";
    }

    /**
     * Post 방식 요청 주소(/login)에 대한 view return 메소드
     * @param memberId 로그인 아이디 값
     * @param memberPwd 로그인 패스워드 값
     * @param toUrl 로그인 페이지(loginForm)로 이동하기 전 page Url
     * @param request 세션 부여 시 사용
     * @param response 쿠키 부여 여부 전달 시 사용
     * @return 사용자 인증 실패시 loginForm(view), 성공 시 main(view)로 이동
     * @throws Exception
     */
    @PostMapping("/login")
    public String login(String memberId, String memberPwd, String toUrl, boolean rememberId,
                        HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("rememberId : " + rememberId);
        log.info("toURL : " + toUrl);

//      1. 아이디와 패스워드 확인 (loginCheck)
        if (!loginCheck(memberId, memberPwd)) {
//          1-1. 아이디와 패스워드가 일치하지 않으면 그 내용을 message에 담에 login 페이지로 redirect
            String message = URLEncoder.encode("아이디 또는 패스워드가 일치하지 않습니다.", StandardCharsets.UTF_8);
            return "redirect:/login/login?message=" + message;
        }
//      2. 아이디와 패스워드가 일치하면
//      2-1. 세션 얻어오기
        HttpSession session = request.getSession();
//      2-2. 세션에 memberId 저장
        MemberDto memberDto = memberService.checkMember(memberId);
        session.setAttribute("memberInfo", memberDto);

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
        toUrl = toUrl == null || toUrl.equals("") ? "/" : toUrl;

        return "redirect:" + toUrl;

    }

    /**
     * 사용자의 아이디와 비밀번호를 DB와 통신을 통해 일치 여부를 확인한다.
     * @param memberId 로그인 아이디 값
     * @param memberPwd 로그인 패스워드 값
     * @return boolean 지역 변수 memberDto의 값이 null 아니면서 memberDto의 pwd 값과 매개변수 memeberPwd의 값이 같으면 true(1) 반환 아니면 false(0)반환
     */
    private boolean loginCheck(String memberId, String memberPwd) throws Exception {

        MemberDto memberDto = null;

        memberDto = memberService.checkMember(memberId);

        return memberDto != null && memberDto.getMember_pwd().equals(memberPwd);

    }

}
