package com.spring.minip.member.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {

    private String member_id;

    private String member_name;

    private String member_pwd;

    private String member_email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date register_date;

    public MemberDto(String member_id, String member_name, String member_pwd, String member_email) {
        this.member_id = member_id;
        this.member_name = member_name;
        this.member_pwd = member_pwd;
        this.member_email = member_email;
    }
}
