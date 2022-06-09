package com.spring.minip.member.dao;

import com.mysql.cj.util.Util;
import com.spring.minip.member.domain.MemberDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    public void insertMember () throws Exception {
        //given
        MemberDto memberDto = new MemberDto("mong1", "Lee", "1234", "222@aaaa");
        System.out.println("memberDto = " + memberDto);
        //when
        memberDao.insertMember(memberDto);



        //then




    }


}