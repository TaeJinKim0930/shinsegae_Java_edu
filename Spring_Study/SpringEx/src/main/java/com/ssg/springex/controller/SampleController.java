package com.ssg.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    public void hello() {
        log.info("Hello ~_~");
    }

    @GetMapping("/ex7")
    public void ex7(String p1, int p2){
        log.info("p1" + p1);
        log.info("p2" + p2);
    }
}
