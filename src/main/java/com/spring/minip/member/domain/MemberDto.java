package com.spring.minip.member.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Builder
@ToString
@Getter
@Setter
public class MemberDto {


    private String member_id;


    private String member_name;

    private String member_pwd;


    private String member_email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date register_date;


}
