package hello.hellospirng.service;

import hello.hellospirng.domain.Member;
import hello.hellospirng.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 테스트 코드는 실제코드에 포함이 되지 않기 때문에,
 * 메소드를 한글로 바꿔도 상관이 없음
 */
class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    /**
     * 테스트 실행해줄때마다 새로 만들어서 같은 MemberService 에 넣어줌
     * Dependency Injectoin, DI
     */
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    /**
     * @AfterEach : Test 하나가 끝날때마다 실행이 되는 것
     * 테스트 한번마다 지워야 되는 이유는 여러개의 메소드를 테스팅 해야 되는데
     * repository 는 하나를 공유해서 쓰기 때문에 충돌이 나서 에러가 날 수 있음.
     * 테스트는 실행순서가 보장이 되지 않음.
     */
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("hello");
        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void duplicatedMemberException() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);

        // try catch 는 사용하기 애매하므로 assertThrows를 사용함.
//        try {
//            memberService.join(member2);
//            fail("예외가 발생해야 합니다");
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 입니다.");
//        }
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 입니다.");
        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}