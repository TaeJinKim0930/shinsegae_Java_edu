package hello.hellospirng.repository;

import hello.hellospirng.domain.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    /**
     * @AfterEach : Test 하나가 끝날때마다 실행이 되는 것
     * 테스트 한번마다 지워야 되는 이유는 여러개의 메소드를 테스팅 해야 되는데
     * repository 는 하나를 공유해서 쓰기 때문에 충돌이 나서 에러가 날 수 있음.
     * 테스트는 실행순서가 보장이 되지 않음.
     */
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }



    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));
        // 저장한 member 와 가져온 member 가 같은지 체크 ==> v

         Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
