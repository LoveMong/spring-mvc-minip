package com.spring.minip.member.controller;

import com.spring.minip.common.validation.MemberValidator;
import com.spring.minip.member.domain.MemberDto;
import com.spring.minip.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 *  회원가입 기능 컨트롤을 위한 클래스
 * @Project : spring-minip
 * @Date : 2022-06-13
 * @author : L
 */

@Slf4j
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private MemberService memberService;


    /**
     * 해당 Controler로 들어오는 요청에 대한 추가적인 설정 메소드
     * @param binder validator 설정을 위한 매개변수
     */
    @InitBinder // 특정 컨트롤러에서 바인딩 또는 검증 설정 변경
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new MemberValidator()); // MemberValidator를 로컬 validator로 등록(Controller 내에서만 사용 가능)
    }

    /**
     * 아이디 중복 체크(ajax) 메소드
     * @param id 중복 여부 확인이 필요한 id 매개변수
     * @return 존재하는 아이디면 -1(사용 불가능), 존재하지 않으면 1(사용 가능) 반환
     * @throws Exception
     */
    @GetMapping("/checkId")
    public int checkId(@RequestParam("member_id") String id) throws Exception {
        log.info("member_id : " + id);
        int result = 0;

        if (!check(id)) {
            result = -1;
        } else {
            result = 1;
        }

        return result;

    }


    /**
     * 회원가입 처리(ajax) 메소드(입력받은 회원정보 유효성 검사 후 DB 저장)
     * @param memberDto 입력받은 회원정보 객체(아이디, 이름, 비밀번호 등)
     * @param result 객체 바인딩 처리시 결과(error) 정보
     * @return ajaxResult 회원가입 실패 시 -1 반환(Binding Error), 성공 시 1 반환
     * @throws Exception
     */
    @PostMapping("/save")
    public int save(@Validated MemberDto memberDto, BindingResult result) throws Exception {
        int ajaxResult = 0;
        log.info("result = " + result);
        log.info("memberDto " + memberDto);

//      수동 검증 - validator를 직접 생성, validate()를 직접 호출
//      MemberValidator memberValidator = new MemberValidator();
//      memberValidator.validate(memberDto, resutl);

//      MemberDto 객체를 검증한 결과 에러가 있으면 loginForm을 이용해서 에러를 보여준다.
        if (result.hasErrors()) {
            ajaxResult =  -1;
        } else {
            memberService.registerMember(memberDto);
            ajaxResult = 1;
        }

        return ajaxResult;

    }

    /**
     * 아이디 중복 여부 확인 메소드
     * @param memberId 확인이 필요한 아디 매개변수
     * @return 확인이 필요한 아이디가 DB 정보에 등록되어 있지 않다면 ture 반환
     * @throws Exception
     */
    private boolean check(String memberId) throws Exception {
        MemberDto memberDto = memberService.checkMember(memberId);
        return memberDto == null;
    }
}

