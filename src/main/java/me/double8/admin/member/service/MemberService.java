package me.double8.admin.member.service;

import lombok.RequiredArgsConstructor;
import me.double8.admin.member.domain.Member;
import me.double8.admin.member.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        member.passwordEncryption(
                new BCryptPasswordEncoder().encode(member.getPassword()));
        memberRepository.save(member);
        return member.getId();
    }

    private void checkSameEmail(Member member) {
        List<Member> findEmail = memberRepository.findByEmail(member.getEmail());
        if (!findEmail.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 이메일 입니다.");
        }
    }

    public Member login(Member member) {
        Member loginMember = checkSameEmailAndPassword(member);
        return loginMember;
    }

    private Member checkSameEmailAndPassword(Member member) {
        Member findMember = memberRepository.findByEmailAndPassword(member.getEmail(), member.getPassword());
        if (member.getEmail().equals(findMember.getEmail()) &&
                new BCryptPasswordEncoder().matches(member.getPassword(), findMember.getPassword())) {
            return findMember;
        } else {
            throw new IllegalStateException("아이디와 비밀번호가 일치하지 않는 회원입니다.");
        }
    }
}
