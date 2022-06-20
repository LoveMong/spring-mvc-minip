package com.spring.minip.member.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Data
public class MemberDto {

    @NotBlank
    private String member_id;

    @NotBlank
    private String member_name;
    @NotBlank
    private String member_pwd;

    @Email
    @NotBlank
    private String member_email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date register_date;

    public MemberDto() {

    }

    public MemberDto(String member_id, String member_name, String member_pwd, String member_email) {
        this.member_id = member_id;
        this.member_name = member_name;
        this.member_pwd = member_pwd;
        this.member_email = member_email;
    }
}
