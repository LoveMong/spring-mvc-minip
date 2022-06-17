package com.spring.minip.member.controller;

import com.spring.minip.common.validation.MemberValidator;
import com.spring.minip.member.domain.MemberDto;
import com.spring.minip.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *  회원가입 기능 컨트롤을 위한 클래스
 * @Project : spring-minip
 * @Date : 2022-06-13
 * @author : L
 */

@Slf4j
@Controller
@RequestMapping("/register")
public class RegisterController {



    @Autowired
    private MemberService memberService;



    /**
     * 해당 Controler로 들어오는 요청에 대한 추가적인 설정 메소드
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new MemberValidator()); // MemberValidator를 로컬 validator로 등록(Controller 내에서만 사용 가능)
        List<Validator> validatorList = binder.getValidators();
        log.error("validator", validatorList);

    }

    /**
     *
     * @param memberDto
     * @param m
     * @return
     * @throws Exception
     */
    @GetMapping("/checkId")
    public String checkId(MemberDto memberDto, Model m) throws Exception {

        m.addAttribute("memberId", memberDto.getMember_id());

        if (!check(memberDto.getMember_id())) {
            m.addAttribute("result", 1);
            return "member/checkID";
        }
        m.addAttribute("result", -1);
        return "member/checkID";
    }



    @PostMapping("/save")
    public String save(@Validated MemberDto memberDto, BindingResult result) throws Exception {

//        수동 검증 - validator를 직접 생성, validate()를 직접 호출
//        MemberValidator memberValidator = new MemberValidator();
//        memberValidator.validate(memberDto, resutl);

//      MemberDto 객체를 검증한 결과 에러가 있으면 loginForm을 이용해서 에러를 보여준다.

        if (result.hasErrors()) {
            return "member/loginForm";
        }

        memberService.registerMember(memberDto);
        return "redirect:/";
    }

    private boolean check(String memberId) throws Exception {
        MemberDto memberDto = memberService.checkMember(memberId);
        return memberDto == null;
    }
}

