package me.double8.admin.member.service;

import lombok.RequiredArgsConstructor;
import me.double8.admin.member.domain.Member;
import me.double8.admin.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService{

    private final MemberRepository memberRepository;

    @Transactional
    public Long joinMemberShip(Member member) {
        checkSameEmail(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void checkSameEmail(Member member) {
        List<Member> findEmail = memberRepository.findByEmail(member.getEmail());
        if (!findEmail.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 이메일 입니다.");
        }
    }
}
