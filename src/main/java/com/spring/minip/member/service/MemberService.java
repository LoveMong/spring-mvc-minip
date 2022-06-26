package com.spring.minip.member.service;

import com.spring.minip.member.domain.MemberDto;

public interface MemberService {
    MemberDto checkMember(String memberId) throws Exception;

    void registerMember(MemberDto memberDto) throws Exception;

    void deleteMember(String memberId) throws Exception;

    void deleteAll() throws Exception;

}
