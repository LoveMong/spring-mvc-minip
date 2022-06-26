package com.spring.minip.member.service;

import com.spring.minip.member.domain.MemberDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberServiceImplTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void loginTest() throws Exception {
        //given
        String memberId = "mong";

        //when
        MemberDto memberDto = memberService.checkMember(memberId);

        //then
        assertEquals(memberId, memberDto.getMember_id());

    }
    
    @Test
    public void registerMember() throws Exception {
        //given
        memberService.deleteAll();

        MemberDto memberDto = MemberDto.builder()
                .member_id("mong2")
                .member_name("몽")
                .member_pwd("1234")
                .member_email("2323@3232")
                .build();

        //when
        memberService.registerMember(memberDto);
        MemberDto memberDto2 = memberService.checkMember(memberDto.getMember_id());

        //then
        assertEquals(memberDto2.getMember_id(), memberDto.getMember_id());
       
    }

    @Test
    public void deleteMember () throws Exception {
        //given
        memberService.deleteAll();

        MemberDto memberDto = MemberDto.builder()
                .member_id("mong")
                .member_name("몽이")
                .member_pwd("1234")
                .member_email("22312@naver.com")
                .build();
        memberService.registerMember(memberDto);


        //when
        memberService.deleteMember(memberDto.getMember_id());

        //then
        MemberDto memberDto1 = memberService.checkMember(memberDto.getMember_id());
        assertNull(memberDto1);


    }

        


}