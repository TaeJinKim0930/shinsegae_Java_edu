package hello.hellospirng;

import hello.hellospirng.repository.MemoryMemberRepository;
import hello.hellospirng.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config 파일에서 MemberService 랑 MemberRepo 를 @Bean 을 통해 직접 연결을 해주고 올려주면
 * @Controller 로 올린 MemberController 랑 연결이 되는 방식
 *
 * 스프링 빈 등록 flow => 스프링 컨테이너 [ controller -> service -> repo ] 컨테이너 안에서 이런식으로 연결이 되어 있습니다.
 *                      ==> DI, Dependency Injection
 */
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
