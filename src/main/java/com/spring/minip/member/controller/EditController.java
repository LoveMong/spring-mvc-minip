package com.spring.minip.member.controller;

import com.spring.minip.common.validation.MemberValidator;
import com.spring.minip.member.domain.MemberDto;
import com.spring.minip.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

/**
 * 회원정보 수정 기능을 위한 클래스 *
 * @Project : spring-minip
 * @Date : 2022-06-28
 * @Author : L
 */
@Slf4j
@Controller
@RequestMapping("/login")
public class EditController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;




    /**
     * 해당 Controler로 들어오는 요청에 대한 추가적인 설정 메소드
     * @param binder validator 설정을 위한 매개변수
     */
    @InitBinder // 특정 컨트롤러에서 바인딩 또는 검증 설정 변경
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new MemberValidator()); // MemberValidator를 로컬 validator로 등록(Controller 내에서만 사용 가능)
    }

    /**
     * Get 방식 요청 Url(/edit)에 대한 view return(editForm) 메소드
     * @param id 회원정보 수정에 요청된 아이디 매개변수
     * @param m 회원정보 객체 전달 매개변수
     * @param session 로그인된 회원의 session 정보 매개변수
     * @return 회원정보 수정 페이지로 이동
     * @throws Exception
     */
    @GetMapping("/edit")
    public String editMember(@RequestParam("memberId") String id, Model m, HttpSession session) throws Exception {
//      로그인 여부 확인(session 정보 유무)
        if (session.getAttribute("memberInfo") == null) {
//          로그인이 되어있지 않다면 로그인 화면으로 이동
            return "/member/loginForm";
        } else  {
//          로그인이 되어있는 상태라면 유저 정보 객체 생성 후 model 객체에 추가
            MemberDto memberDto = memberService.checkMember(id);
            m.addAttribute("memberInfo", memberDto);
        }

        return "/member/editForm";

    }

    /**
     * 회원정보 수정 처리(ajax) 메소드(입력받은 회원정보 유효성 검사 후 DB 저장 및 결과 반환)
     * @param memberDto 입력받은 회원정보 객체(비밀번호, 이메일 정보)
     * @param result 객체 바인딩 처리 시 결과(error) 정보
     * @return 회원정보 수정 실패 시 -1 반환(Binding Error), 성공 시 1 반환
     * @throws Exception
     */
    @PostMapping("/edit")
    @ResponseBody
    public int editMember(@Validated MemberDto memberDto, BindingResult result) throws Exception {

        int ajaxResult = 0;
//      validation 이상 유무 확인
        if (result.hasErrors()) {
//          error 발견 시 실패 정보(-1) ajaxResult 변수에 반영
            ajaxResult = -1;
        } else {
//          이상 없으면 변경된 정보를 객체에 반영(비밀번호 Encoder) 후 DB저장 및 ajaxResult 변수에 반영
            memberDto.setMember_pwd(bCryptPasswordEncoder.encode(memberDto.getMember_pwd()));
            memberService.editMember(memberDto);
            ajaxResult = 1;
        }

        return ajaxResult;

    }


}
