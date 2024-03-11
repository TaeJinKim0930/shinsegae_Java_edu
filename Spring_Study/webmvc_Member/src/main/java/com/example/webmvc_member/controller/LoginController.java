package com.example.webmvc_member.controller;

import com.example.webmvc_member.dto.MemberDTO;
import com.example.webmvc_member.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@Log4j2
@WebServlet("/login")
public class LoginController extends HttpServlet {
    // Get
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.info("login get...");
        req.getRequestDispatcher("/WEB-INF/todo/login.jsp").forward(req, res);
    }

    // Post
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.info("login post called..");
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        try {
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO);
            res.sendRedirect("/member");

        } catch (Exception e) {
            res.sendRedirect("/login?result=error");
//            throw new RuntimeException(e);
        }
    }
}