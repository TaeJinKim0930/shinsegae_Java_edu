package com.example.jdbcex.controller.todo;

import com.example.jdbcex.dto.TodoDTO;
import com.example.jdbcex.todoService.TodoServiceEnum;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@Log4j2
@WebServlet(name = "TodoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController2 extends HttpServlet {
    private TodoServiceEnum todoService = TodoServiceEnum.INSTANCE;

    // Get
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("입력 화면을 볼 수 있도록 구성");
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

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        dispatcher.forward(req, res);
    }

    // Post
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("입력을 처리하고 목록 페이지로 이동");
        String title = req.getParameter("title");
        LocalDate date = LocalDate.parse(req.getParameter("date"));

        TodoDTO todoDTO = new TodoDTO().builder()
                .title(title)
                .dueDate(date)
                .finished(false)
                .build();

        todoService.register(todoDTO);

        req.setAttribute("title", title);
        req.setAttribute("date", date);

        res.sendRedirect("/todo/list?title=" + title + "&date=" + date);
    }
}
