package com.spring.minip.member.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;



@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class MemberDto {
    @NonNull
    private String member_id;
    @NonNull
    private String member_name;
    @NonNull
    private String member_pwd;
    @NonNull
    private String member_email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date register_date;

}
