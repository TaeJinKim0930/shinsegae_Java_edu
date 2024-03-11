package com.example.webmvc_member.controller;

import com.example.webmvc_member.service.MemberService;
import com.example.webmvc_member.util.MapperUtil;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@WebServlet(name="DeleteController", urlPatterns = "/member/delete")
public class DeleteController extends HttpServlet {
    MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.info("Member Delete Controller... /member/delete");
        req.getRequestDispatcher("/WEB-INF/todo/listMembers.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String mid = req.getParameter("mid");
            String mpw = req.getParameter("mpw");
            memberService.deleteMember(mid, mpw);
            res.sendRedirect("/member");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
