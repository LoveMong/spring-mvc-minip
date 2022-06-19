package com.spring.minip.common.validation;

import com.spring.minip.member.domain.MemberDto;
import com.sun.javadoc.MemberDoc;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import javax.naming.Binding;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.*;

public class MemberValidatorTest {

    private static MemberValidator memberValidator;


    @Test
    public void validation () throws Exception {
        //given
        MemberDto memberDto = new MemberDto("", "adfsaf", "1233", "eerwer@werwe");
        Errors errors = new BeanPropertyBindingResult(memberDto, "memberDto");

        //when
        memberValidator.validate(memberDto, errors);

        //then


    }

}