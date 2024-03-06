package hello.hellospirng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    /**
     * 웹 어플리케이션에서 /hello 라고 들어오면 @GetMapping("hello") 인 여기를 호출을 해줌
     * localhost:8080/hello
     * GetMapping 의 get 은 get/post/put/delete 에서의 Get 임.
     * @param model :
     * @return hello : hello 라는 html 파일을 찾아서 값을 넘겨라는 뜻임. hello.html 파일이 없으면 
     *                  TemplateInputException 에러가 발생
     */
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    /**
     * hellow-mvc : 웹에서 접근 할 때의 주소 /hello-mvc
     * name : controller 에 넘겨주는 값
     * hello-template : html 파일 이름
     *
     * @param name
     * @param model : 넘겨주면 View 에서 rendering 을 할때 사용
     * @return
     */
    @GetMapping("hello-mvc")
    public String hellowMvc(@RequestParam("name") String name, Model model) {
        // 두번째 name 의 값은 입력값으로 받기 때문에 홈페이지를 열때, /hellow-mvc?name=anything 이렇게 열어야 됌
        model.addAttribute("name", name);
        return "hello-template";
    }

    /**
     * @ResponseBody : http 에서 body 파트에 데이터를 직접 넣어 주겠다는 뜻
     * 위에 진행한 방식의 소스 코드를 보면 html 코드들이 보이는데 이런식으로 진행을 하면
     * 소스 코드를 보아도 hello tj 라는 값 밖에 없음
     * view template 을 거치지 않고 바로 보내기 때문에 가능
     * 하지만 별로 쓰지 않는 방법
     * @param name
     * @return
     */
    @GetMapping("hello-string")
    @ResponseBody
    public String helloSTring(@RequestParam("name") String name) {
        // 만약 이름 값에 tj 라고 넣으면 "hello tj" 라고 출력이 됌.
        return "hello " + name;
    }

    /**
     * 이 방식을 많이 씀
     * API 방식
     * /hello-api?name=anything
     * ==> {"name" : "tj"} 이런식으로 JSON 방식으로 출력이 됌
     *
     * @ResponseBody 로 하면 암묵적으로 기본적으로 JSON 으로 반환을 하는거로 되어 있음
     *
     * 작동 방법: 웹 -> 톰캣 서버 -> helloController로 오는데 @ResponseBody 가 있으면,
     *          객체가 왔을 경우 JsonConverter 가 작동을 해서 JSON 방식으로 데이터를 만들어서 Http 응답에 반환을 함
     *          String 일 경우 StringConverter가 작동을 해서 String 으로 반환함
     */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
