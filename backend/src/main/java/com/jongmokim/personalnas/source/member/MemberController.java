package com.jongmokim.personalnas.source.member;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jongmokim.personalnas.source.member.dto.MemberDTO;
import com.jongmokim.personalnas.source.member.entity.Member;

@RestController
@RequestMapping("/members")
public class MemberController {

    
    private MemberRepository memberRepository;

    private MemberController(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    @GetMapping("")
    public ResponseEntity<List<Member>> memberList() {
        List<Member> findAll = memberRepository.findAll();
        return ResponseEntity.ok(findAll);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Member> memberDetail(@PathVariable UUID uuid) throws Exception{
        Member member = memberRepository.findById(uuid).orElseThrow(() -> new Exception("WTF"));
        return ResponseEntity.ok(member);
    }
    
    @PostMapping("")
    public ResponseEntity<Member> memberInsert(@Valid MemberDTO member) {
        Member inputMember = member.toMember();
        memberRepository.saveAndFlush(inputMember);
        return ResponseEntity.ok().body(inputMember);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Member> memberDelete(@PathVariable UUID uuid) throws Exception {
        Member searchedMember = memberRepository.findById(uuid).orElseThrow(() -> new Exception("asd"));
        memberRepository.delete(searchedMember);
        memberRepository.flush();
        return ResponseEntity.ok().body(searchedMember);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Member> memberUpdate(@PathVariable UUID uuid, @Valid MemberDTO member) throws Exception {
        Member inputMember = member.toMember();
        Member searchedMember = memberRepository.findById(uuid).orElseThrow(() -> new Exception("WTF"));
        searchedMember.updateMemberInfo(inputMember);            
        memberRepository.saveAndFlush(inputMember);
        return ResponseEntity.ok().body(searchedMember);
    }
}
