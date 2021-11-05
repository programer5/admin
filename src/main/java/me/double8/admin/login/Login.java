package me.double8.admin.login;

import me.double8.admin.member.domain.Member;
import org.springframework.stereotype.Component;

@Component
public interface Login {

    /**
     * 로그인을 하기 위해서 선행되어야 할 행위
     * 회원 가입
     */
    Long joinMemberShip(Member member);
}
