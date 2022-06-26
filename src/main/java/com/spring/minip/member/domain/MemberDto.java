package com.spring.minip.member.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;


@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor // 파라미터가 없는 기본 생성자 생성
@AllArgsConstructor // 필드 값을 파라미터로 받는 생성자 생성
//@RequiredArgsConstructor // final 또는 @NonNull인 필드 값만 파라미터로 받는 생성자 생성
public class MemberDto {


    private String member_id;

    private String member_name;

    private String member_pwd;

    private String member_email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date register_date;


}



//@Builder
















