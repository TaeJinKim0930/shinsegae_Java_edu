package hello.hellospirng.repository;

import hello.hellospirng.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    // Optional 은 null 의 값이 들어 왔을 경우 받아줌 : Java8기능
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
