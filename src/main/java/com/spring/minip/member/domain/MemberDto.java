package com.spring.minip.member.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;


public class MemberDto {


    private String member_id;


    private String member_name;

    private String member_pwd;


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

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public String getMember_pwd() {
        return member_pwd;
    }

    public void setMember_pwd(String member_pwd) {
        this.member_pwd = member_pwd;
    }

    public String getMember_email() {
        return member_email;
    }

    public void setMember_email(String member_email) {
        this.member_email = member_email;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "member_id='" + member_id + '\'' +
                ", member_name='" + member_name + '\'' +
                ", member_pwd='" + member_pwd + '\'' +
                ", member_email='" + member_email + '\'' +
                ", register_date=" + register_date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDto memberDto = (MemberDto) o;
        return Objects.equals(member_id, memberDto.member_id) && Objects.equals(member_name, memberDto.member_name) && Objects.equals(member_pwd, memberDto.member_pwd) && Objects.equals(member_email, memberDto.member_email) && Objects.equals(register_date, memberDto.register_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member_id, member_name, member_pwd, member_email, register_date);
    }

}
