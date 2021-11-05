package me.double8.admin.member.service;

import lombok.RequiredArgsConstructor;
import me.double8.admin.login.Login;
import me.double8.admin.member.domain.Member;
import me.double8.admin.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService implements Login {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long joinMemberShip(Member member) {
        checkSameEmail(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void checkSameEmail(Member member) {
        if (!member.getEmail().isEmpty()) {
            throw new IllegalStateException("이미 가입된 이메일 입니다.");
        }
    }
}
