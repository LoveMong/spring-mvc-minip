package com.spring.minip.member.service;

import com.spring.minip.member.domain.MemberDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

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
        MemberDto memberDto1 = new MemberDto("mong3", "Lee", "1234", "eeee@eeee" );

        //when
        memberService.registerMember(memberDto1);
        MemberDto memberDto2 = memberService.checkMember(memberDto1.getMember_id());

        //then
        assertEquals(memberDto2.getMember_id(), memberDto1.getMember_id());

       
    }
        


}