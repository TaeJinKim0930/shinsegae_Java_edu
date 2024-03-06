package hello.hellospirng.controller;

import hello.hellospirng.domain.Member;
import hello.hellospirng.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Controller 를 적어주면 스프링이 실행이 될때 MemberController 가 자동적으로 객채를 생성을 하고 Bean을 관리를 해줍니다.
 *
 * 스프링 빈 등록 flow => 스프링 컨테이너 [ controller -> service -> repo ] 컨테이너 안에서 이런식으로 연결이 되어 있습니다.
 *      DI, Dependency Injection
 */
@Controller
public class MemberController {
    private final MemberService memberService;

    /**
     * @Autowire 는 spring container 에 있는 MemberService 를 가져다 써줌으로서 해당 MemberService 를 여러개를 생성하지 않고
     * 실행이 될 때 생성 된 MemberService 를 연결을 해주는 역할을 합니다. 그러므로 하나만 생성하고 돌려서 쓸 수 있게되는 겁니다.
     *
     * @Autowired 를 필드, Setter 로 주입도 가능하지만 이 코드처럼 Constructor 생성자로 생성을 하는 것이 제일 많이 쓰입니다.
     * 의존관계가 실행중에 동적으로 변경하는 경우가 거의 없으므로 setter 로 생성을 할 일이 거의 없기때문에 생성자로 쓰는 겁니다.
     * @param memberService
     */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        
        // home 화면으로 다시 돌려보내주는 기능
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
