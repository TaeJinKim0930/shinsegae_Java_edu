package hello.hellospirng.service;

import hello.hellospirng.domain.Member;
import hello.hellospirng.repository.MemberRepository;
import hello.hellospirng.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service 는 비지니스 의존적으로 설계를 해야 되기 때문에
 * 이름들을 할 때 비지니스 이름으로 네이밍을 해야 됌
 *
 * @Service 를 하면 Spring 이 실행이 될때 얘가 Service 라는걸 인지를 하고 알아서 container 에 등록을 해줍니다.
 */

public class MemberService {
    private final MemberRepository memberRepository;

    /**
     * 내가 직접 생성하는게 아니라 외부에서 넣어주는 방법으로 바꿔줌으로서
     * 여러개의 인스턴스를 생성하는 것을 막아 줌
     * DI, Dependency Injection.
     * 생성자로 넣어 줬으니 생성자 주입
     * @param memberRepository
     */
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     *
     * @param member
     * @return
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원x
        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    // 같은 이름이 있는 중복 회원x
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원 입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
