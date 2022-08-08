package com.jongmokim.personalnas.source.member.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.jongmokim.personalnas.source.member.entity.Member;

public class MemberDTO {
    
    private UUID uuid;

    @NotBlank
    private String id;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    public Member toMember() {
        return Member.builder()
                .uuid(this.uuid)
                .id(this.id)
                .password(this.password)
                .name(this.name)
        .build();
    }
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
