package com.spring.minip.member.service;

import com.spring.minip.member.dao.MemberDao;
import com.spring.minip.member.domain.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public MemberDto checkMember(String memberId) throws Exception {
        return memberDao.selectMember(memberId);
    }

    @Override
    public void registerMember(MemberDto memberDto) throws Exception {
        memberDao.insertMember(memberDto);
    }
}
