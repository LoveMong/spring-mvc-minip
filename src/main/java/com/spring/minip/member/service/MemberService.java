package com.spring.minip.member.service;

import com.spring.minip.member.domain.MemberDto;

public interface MemberService {
    MemberDto login(String memberId) throws Exception;
}
