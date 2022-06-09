package com.spring.minip.member.dao;

import com.spring.minip.member.domain.MemberDto;


public interface MemberDao {
    MemberDto selectMember(String memberId) throws Exception;

    void insertMember(MemberDto dto) throws Exception;
}
