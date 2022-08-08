package com.jongmokim.personalnas.source.member.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MemberTest {
    
    @Test
    @DisplayName("멤버 equal 테스트")
    void MemberEqualTest() {
        UUID uuid = UUID.randomUUID();
        Object mem1 = null;
        Member mem2 = Member.builder()
                    .id("id")
                    .name("name")
                    .password("password")
                    .registerDate(new Date(0L))
                    .uuid(uuid)
                    .build();
        assertFalse(mem2.equals(mem1));

        Object exception = new Exception();
        assertFalse(Objects.equals(mem2, exception));

        mem1 = Member.builder().id("id").build();
        assertFalse(mem2.equals(mem1));

        mem1 = Member.builder().name("name").build();
        assertFalse(mem2.equals(mem1));

        mem1 = Member.builder().id("id").name("name").password(null).build();
        assertFalse(mem2.equals(mem1));

        mem1 = Member.builder().id("id").name("name").password("password").registerDate(null).build();
        assertFalse(mem2.equals(mem1));

        mem1 = Member.builder().id("id").name("name").password("password").registerDate(new Date(0L)).uuid(null).build();
        assertFalse(mem2.equals(mem1));
    }

    @Test
    @DisplayName("멤버 정보 변경")
    void updateMemberInfo() {
        Member mem = new Member();
        Member modifyMember = Member.builder().id("id").name("name").password("password").registerDate(new Date(0L)).uuid(null).build();
        mem.updateMemberInfo(modifyMember);
        assertEquals(mem.getId(), modifyMember.getId());
        assertEquals(mem.getName(), modifyMember.getName());
        assertEquals(mem.getPassword(), modifyMember.getPassword());
    }
}
