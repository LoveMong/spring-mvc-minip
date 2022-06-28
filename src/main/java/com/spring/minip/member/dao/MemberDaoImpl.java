package com.spring.minip.member.dao;

import com.spring.minip.member.domain.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {


    @Autowired
    private SqlSession session; //  SQL 명령을 수행하는데 필요한 메서드 제공(SqlSession의 주요 메서드 확인 필요)

    private static String namespace = "com.spring.minip.member.dao.MemberMapper.";

    @Override
    public MemberDto selectMember(String memberID) throws Exception {
        return session.selectOne(namespace + "selectMember", memberID);
    }

    @Override
    public void insertMember(MemberDto dto) throws Exception {
        session.insert(namespace + "insertMember", dto);
    }

    @Override
    public void deleteAll() throws Exception {
        session.delete(namespace + "deleteAll");
    }

    @Override
    public void deleteMember(String memberId) throws Exception {
        session.delete(namespace + "deleteMember", memberId);
    }

    @Override
    public void updateMember(MemberDto memberDto) throws Exception {
        session.update(namespace + "updateMember", memberDto);
    }


}
