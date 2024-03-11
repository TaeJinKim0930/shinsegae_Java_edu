package com.example.webmvc_member.controller;

import com.example.webmvc_member.dto.MemberDTO;
import com.example.webmvc_member.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Log4j2
@WebServlet(name="ModifyController", urlPatterns = "/member/modify")
public class ModifyController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.info("Modify Member Controller... /member/modify");


        MemberDTO dto = null;
        try {
            dto = memberService.get(req.getParameter("mid"));
            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(req, res);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String id = req.getParameter("mid");
            String pw = req.getParameter("mpw");
            String name = req.getParameter("mname");
            String email = req.getParameter("memail");
            LocalDate date = LocalDate.now();

            // Password validation regex
            String regexPw = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W]).{8,30}$";


            if (pw == null || pw.isEmpty() || !pw.matches(regexPw)) {
                log.info("비밀번호 자리수 에러: " + pw.length());
                req.setAttribute("result", "error");
                req.setAttribute("status", "fail");
                List<MemberDTO> dtoList = memberService.listAll(); // Retrieve member list again
                req.setAttribute("dtoList", dtoList);
                req.getRequestDispatcher("/WEB-INF/todo/listMembers.jsp").forward(req, res);
            } else {
                // Update member data in the database
                MemberDTO memberDTO = MemberDTO.builder()
                        .mid(id)
                        .mpw(pw)
                        .mname(name)
                        .memail(email)
                        .reg_date(date)
                        .build();

                memberService.updateOne(memberDTO); // Update member data

                log.info("Member data updated successfully");
                req.setAttribute("status", "success");
                res.sendRedirect("/member"); // Redirect to the member list page
            }
        } catch (Exception e) {
            throw new ServletException("Error processing modification request", e);
        }
    }

}
