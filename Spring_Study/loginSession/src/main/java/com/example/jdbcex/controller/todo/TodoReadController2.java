package com.example.jdbcex.controller.todo;

import com.example.jdbcex.dto.TodoDTO;
import com.example.jdbcex.todoService.TodoServiceEnum;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TodoReadController", urlPatterns = "/todo/read")
public class TodoReadController2 extends HttpServlet {
    private TodoServiceEnum todoService = TodoServiceEnum.INSTANCE;

    // Get
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            System.out.println("/todo/read");
            Long tno = Long.parseLong(req.getParameter("tno"));
            System.out.println("tno: " + tno);

            TodoDTO dto = todoService.get(tno);
            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, res);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("수정 페이지로 이동");
        res.sendRedirect("/todo/modify?tno=" + req.getParameter("tno"));
    }

}
