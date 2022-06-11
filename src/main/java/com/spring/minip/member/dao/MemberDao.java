package com.spring.minip.member.dao;

import com.spring.minip.member.domain.MemberDto;


public interface MemberDao {

//  회원 정보 조회(사용자 인증에 사용)
    MemberDto selectMember(String memberId) throws Exception;

//  회원 가입
    void insertMember(MemberDto dto) throws Exception;
}
