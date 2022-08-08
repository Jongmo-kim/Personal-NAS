package com.jongmokim.personalnas.source.member;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jongmokim.personalnas.source.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member,UUID>{
    
}
