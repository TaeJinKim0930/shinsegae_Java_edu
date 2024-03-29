package com.ssg.springproduct.controller;

import com.ssg.springproduct.dto.PageRequestDTO;
import com.ssg.springproduct.dto.ProductDTO;
import com.ssg.springproduct.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
        log.info("product list...!!!");

        if (bindingResult.hasErrors()) {
            // reset
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", productService.getList(pageRequestDTO));
    }

    @GetMapping("/register")
    public void register() {
        log.info("product register...!!!");
    }

    @PostMapping("/register")
    public String registerPost(@Valid ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("product post register...!!!");

        if (bindingResult.hasErrors()) {
            log.info("ERROR PPI O PPI O PPI O PPI O");
            redirectAttributes.addAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/product/register";
        }

        log.info("productDTO: " + productDTO);
        productService.register(productDTO);

        return "redirect:/product/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long pno, PageRequestDTO pageRequestDTO , Model model) {
        ProductDTO productDTO = productService.getOne(pno);
        log.info(productDTO);

        model.addAttribute("dto", productDTO);
    }

    @PostMapping("/remove")
    public String remove(Long pno, RedirectAttributes redirectAttributes) {
        log.info("remove post ...!!!");
        log.info("pno : " + pno);
        productService.remove(pno);
        return "redirect:/product/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            log.info("Update Fail : has Errors");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("pno", productDTO.getPno());
            return "redirect:/product/modify";
        } else {
            log.info(productDTO);

            productService.modify(productDTO);
            return "redirect:/product/list";
        }

    }
}