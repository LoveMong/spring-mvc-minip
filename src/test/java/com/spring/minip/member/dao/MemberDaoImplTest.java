package com.spring.minip.member.dao;

import com.mysql.cj.util.Util;
import com.spring.minip.member.domain.MemberDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Member;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDaoImplTest {

    @Autowired
    private MemberDao memberDao;

    @Test
    public void selectMember () throws Exception {
        //given
        String memberId = "mong";
        //when
        MemberDto memberDto1 = memberDao.selectMember(memberId);

       //then

        assertEquals(memberId, memberDto1.getMember_id());


    }

    @Test
    public void deleteAll () throws Exception {
        //given
        for (int i = 0; i < 10; i++) {
            MemberDto memberDto = MemberDto.builder()
                    .member_id("mong" + i)
                    .member_name("몽이")
                    .member_pwd("1234")
                    .member_email("2222@222.net")
                    .build();

            memberDao.insertMember(memberDto);
        }

        //when
        memberDao.deleteAll();

        //then
        MemberDto memberDto = MemberDto.builder()
                .member_id("mong1")
                .build();
        MemberDto memberDto1 = memberDao.selectMember(memberDto.getMember_id());
        assertNull(memberDto1);

    }

    @Test
    public void deleteMember () throws Exception {
        //given
        memberDao.deleteAll();

        for (int i = 0; i < 5; i++) {
            MemberDto memberDto = MemberDto.builder()
                    .member_id("mong" + i)
                    .member_name("몽이")
                    .member_pwd("1234")
                    .member_email("2222@222.net")
                    .build();

            memberDao.insertMember(memberDto);
        }

        //when
        memberDao.deleteMember("mong2");

        //then
        MemberDto memberDto = memberDao.selectMember("mong2");
        assertNull(memberDto);


    }



    @Test
    public void insertMember () throws Exception {
        //given
        memberDao.deleteAll();

        MemberDto memberDto = MemberDto.builder()
                .member_id("mong1")
                .member_name("몽이이")
                .member_pwd("1234")
                .member_email("2323@3232.net")
                .build();
        System.out.println("memberDto = " + memberDto);
        //when
        memberDao.insertMember(memberDto);
        MemberDto memberDto1 = memberDao.selectMember(memberDto.getMember_id());

        //then
        assertEquals(memberDto1.getMember_id(), memberDto.getMember_id());


    }


}