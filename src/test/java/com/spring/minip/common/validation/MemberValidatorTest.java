package com.spring.minip.common.validation;

import com.spring.minip.member.domain.MemberDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberValidatorTest {


    private MemberValidator memberValidator;


    @Test
    public void validation() throws Exception {
        //given
        MemberDto memberDto = new MemberDto("asdf", "adfsaf", "1233", "eerwer@werwe");
        Errors errors = new BeanPropertyBindingResult(memberDto, "memberDto");

        //when
        memberValidator.validate(memberDto, errors);

        //then




    }

}