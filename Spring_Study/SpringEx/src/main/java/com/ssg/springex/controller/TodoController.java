package com.ssg.springex.controller;

import com.ssg.springex.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {

    @RequestMapping("/list")
    public void list() {
        log.info("here is ur list");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register() {
        log.info("register is here");
    }

    @PostMapping("/register")
    public void registerPost(TodoDTO todoDTO) {
        log.info("post todo register...");
        log.info(todoDTO);
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("ex1...");
        log.info("너의이름은: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "SSG") String name,
                    @RequestParam(name = "age", defaultValue = "20") int age) {
        log.info("ex1...");
        log.info("너의이름은: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        log.info("ex3 ...");
        log.info("dueDate" + dueDate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model) {
        log.info("======================================= ex4 ... ======================================= ");
        model.addAttribute("msg","hello ex4");
    }

    @GetMapping("/ex4_1")
    public void ex4Extra(@ModelAttribute("dto") TodoDTO todoDTO, Model model) {
        log.info(todoDTO);
    }

    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("name","aaa");
        redirectAttributes.addFlashAttribute("result", "success");
        return "redirect:/todo/ex6";
    }

    @GetMapping("/ex6")
    public void ex6(){}

}
