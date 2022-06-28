package com.spring.minip.member.controller;

import com.spring.minip.member.domain.MemberDto;
import com.spring.minip.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@RequestMapping("/login")
public class EditController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/edit")
    public String editMember(@RequestParam("memberId") String id, Model m) throws Exception {

        MemberDto memberDto = memberService.checkMember(id);

        m.addAttribute("memberInfo", memberDto);

        return "/member/editForm";

    }

    @PostMapping("/edit")
    @ResponseBody
    public int editMember(@Validated MemberDto memberDto, BindingResult result) throws Exception {

        int ajaxResult = 0;

        if (result.hasErrors()) {
            ajaxResult = -1;
        } else {
            memberDto.setMember_pwd(bCryptPasswordEncoder.encode(memberDto.getMember_pwd()));
            memberService.editMember(memberDto);
            ajaxResult = 1;
        }
        return ajaxResult;

    }


}
