package com.jongmokim.personalnas.source.member;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jongmokim.personalnas.source.member.entity.Member;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MemberControllerTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MockMvc mockMvc;

    private Date registerDate1 = new Date(System.currentTimeMillis() + 100L);
    private Date registerDate2 = new Date(System.currentTimeMillis() + 200L);
    private Date registerDate3 = new Date(System.currentTimeMillis() + 300L);
    @BeforeEach
    void memberInit() {
        Member member1 = Member.builder()
            .id("id1")
            .name("name1")
            .password("password1")
            .registerDate(registerDate1)
            .uuid(UUID.randomUUID())
            .build();
        Member member2 = Member.builder()
            .id("id2")
            .name("name2")
            .password("password2")
            .registerDate(registerDate2)
            .uuid(UUID.randomUUID())
            .build();
        Member member3 = Member.builder()
            .id("id3")
            .name("name3")
            .password("password3")
            .registerDate(registerDate3)
            .uuid(UUID.randomUUID())
            .build();

        memberRepository.saveAllAndFlush(Arrays.asList(member1,member2,member3));
    }

    @AfterEach
    void memberDelete() {
        memberRepository.deleteAll();
        memberRepository.flush();
    }

    @Test
    @DisplayName("멤버 조회")
    void memberSelectTest() throws Exception{
        List<Member> findAll = memberRepository.findAll();
        Member member = findAll.get(0);

        Member searchedMember = memberRepository.findById(member.getUuid()).get();
        assertTrue(member.equals(searchedMember));

        mockMvc.perform(get("/members")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.[*]",hasSize(3)))
            .andDo(print());
            
    }

    @Test
    @DisplayName("멤버 상세 조회")
    void memberDetailTest() throws Exception{
        List<Member> findAll = memberRepository.findAll();
        Member member = findAll.get(0);
        mockMvc.perform(get("/members/" + member.getUuid().toString())
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.uuid").value(member.getUuid().toString()))
                    .andDo(print());

        try{
            mockMvc.perform(get("/members/" + UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e){

        }
    }

    @Test
    @DisplayName("멤버 추가")
    void memberInsertTest() throws Exception{
        String id = "temp-id";
        String name = "temp-name";
        String password = "temp=password";
        MvcResult result = mockMvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", id)
                        .param("name", name)
                        .param("password", password)
                        .with(csrf())
                    )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andReturn();
        String json = result.getResponse().getContentAsString();
        Member member = new ObjectMapper().readValue(json, Member.class);
        
        Member member2 = memberRepository.findById(member.getUuid()).get();

        assertTrue(member.equals(member2));
        
    }

    @Test
    @DisplayName("멤버 삭제")
    void memberDeleteTest() throws Exception{
        List<Member> findAll = memberRepository.findAll();
        Member member = findAll.get(0);


        mockMvc.perform(
                    delete("/members/"+ member.getUuid().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(csrf())
                )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(member.getId()));

        assertFalse(memberRepository.existsById(member.getUuid()));

        try{
            mockMvc.perform(
                delete("/members/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .with(csrf())
            )
            .andExpect(status().is4xxClientError())
            .andReturn();
        } catch (Exception e) {

        }
    }

    @Test
    @DisplayName("멤버 수정")
    void memberUpdateTest() throws Exception{
        String id = "temp-id";
        String name = "temp-name";
        String password = "temp=password";

        List<Member> findAll = memberRepository.findAll();
        Member member = findAll.get(0);
        MvcResult result = mockMvc.perform(
                    put("/members/" + member.getUuid().toString())
                    .contentType(MediaType.APPLICATION_JSON)
                    .param("id", id)
                    .param("name", name)
                    .param("password", password)
                    .with(csrf())
                )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id))
                .andReturn();
        
        String json = result.getResponse().getContentAsString();
        Member resultMember = new ObjectMapper().readValue(json, Member.class);
        Member searchedMember = memberRepository.findById(member.getUuid()).get();
        assertTrue(resultMember.equals(searchedMember));
        assertTrue(searchedMember.getId().equals(id));
        assertTrue(searchedMember.getName().equals(name));
        assertTrue(searchedMember.getPassword().equals(password));

        try{
            mockMvc.perform(
                put("/members/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .param("id", id)
                .param("name", name)
                .param("password", password)
                .with(csrf())
            )
            .andExpect(status().is4xxClientError())
            .andReturn();
        } catch (Exception e) {

        }
    }
}
