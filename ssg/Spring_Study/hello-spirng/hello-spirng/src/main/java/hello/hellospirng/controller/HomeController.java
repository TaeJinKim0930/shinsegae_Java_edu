package hello.hellospirng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * 디폴트 페이지
     * @return
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
