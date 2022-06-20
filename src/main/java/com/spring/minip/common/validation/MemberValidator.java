package com.spring.minip.common.validation;

import com.spring.minip.member.domain.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * MemberDto 객체 검증 클래스
 */
@Slf4j
public class MemberValidator implements Validator {
//  (Interface)validator : 데이터를 검증하기 위한 인터페이스

    /**
     * 매개변수로 들어온 클래스가 이 검증기로 검증가능한 객체인지 알려주는 메서드
     * @param clazz the {@link Class} that this {@link Validator} is
     * being asked if it can {@link #validate(Object, Errors) validate}
     * @return 매개변수의 객체가 MemberDto 타입일 경우에만 검증 가능(true 반환)
     */
    @Override
    public boolean supports(Class<?> clazz) {
//      return MemberDto.class.isAssignableFrom(clazz); clazz가 MemberDto 또는 그 자손인지 확인
        return MemberDto.class.equals(clazz);
    }

    /**
     * 객체를 검증하는 메서드
     * @param target the object that is to be validated (can be {@code null}) 검증할 객체
     * @param errors contextual state about the validation process (never {@code null}) 검증시 발생한 에러 저장소
     */
    @Override
    public void validate(Object target, Errors errors) {
        log.info("LocalValidator,validate() is called");

//      (Interface) Errors : 객체 전체에 대한 error를 저장(reject) 또는 필드(id, pwd)에 대한 error를 저장(rejectValue)
//      target은 MemberDto 타입으로 형변환, InstanceOf는 생략(위 supports 메서드에서 이미 확인)
        MemberDto memberDto = (MemberDto)target;

        String member_id = memberDto.getMember_id();

//      memberId가 null이거나 빈 문자열이면 memberId 필드에서 required 라는 error 코드 저장
      if (member_id == null || "".equals(member_id.trim())) {
         errors.rejectValue("member_id", "required", "id는 필수값 입니다.");
      }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "member_id", "required", "id는 필수값 입니다.");





    }
}
