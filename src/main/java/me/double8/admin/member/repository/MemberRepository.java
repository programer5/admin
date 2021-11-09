package me.double8.admin.member.repository;

import me.double8.admin.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByEmail(String email);

    Member findByEmailAndPassword(String email, String password);


}
