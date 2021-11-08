package me.double8.admin.member.service;

import me.double8.admin.member.domain.Member;
import me.double8.admin.member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;

    @Test
    @DisplayName("회원 가입")
    void join() {
        //given
        Member member = new Member(1L, "test@test.com", "test");

        //when
        Long memberId = memberService.joinMemberShip(member);

        //then
        assertThat(memberId).isEqualTo(member.getId());
    }
}