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
import java.util.List;

@Log4j2
@WebServlet(name="MemberController", urlPatterns = "/member")
public class MemberController extends HttpServlet {
    private MemberService memberService = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        log.info("Get Member List.../member");

        try {
            log.info("입력 화면을 볼 수 있도록 구성");
            // 사용자의 req 에 session 값을 하나 가져와서 세션 기능을 부여해줌
            HttpSession session = req.getSession();
            if(session.isNew()) {
                res.sendRedirect("/login");
                return;
            }

            // 로그인한 정보가 없다면
            if(session.getAttribute("loginInfo") == null) {
                log.info("로그인한 정보가 없는 사용자 입니다");
                res.sendRedirect("/login");
                return;
            }

            List<MemberDTO> dtoList = memberService.listAll();
            req.setAttribute("dtoList", dtoList);
            req.getRequestDispatcher("/WEB-INF/todo/listMembers.jsp").forward(req, res);

        } catch (Exception e) {
            throw new ServletException("List Error: " + e.getMessage(), e);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 수정
        log.info("Post member List...");
        String mid = req.getParameter("mid");
        res.sendRedirect("/member/addMember.do");

    }
}
