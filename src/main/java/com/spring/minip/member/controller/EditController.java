package com.spring.minip.member.controller;

import com.spring.minip.member.domain.MemberDto;
import com.spring.minip.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/login")
public class EditController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/edit")
    public String editMember(@RequestParam("memberId") String id, Model m) throws Exception {

        MemberDto memberDto = memberService.checkMember(id);

        m.addAttribute("memberInfo", memberDto);

        return "member/editForm";

    }

    @PostMapping("/edit")
    public int editMember(@Validated MemberDto memberDto) {



    }


}
