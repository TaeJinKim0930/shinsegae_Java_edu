package com.example.jdbcex.controller.todo;

import com.example.jdbcex.domain.TodoVO;
import com.example.jdbcex.dto.TodoDTO;
import com.example.jdbcex.todoService.TodoServiceEnum;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "TodoModifyController", urlPatterns = "/todo/modify")
public class TodoModifycontroller2 extends HttpServlet {
    private TodoServiceEnum todoService = TodoServiceEnum.INSTANCE;

    // Get
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            System.out.println("/todo/modify");
            Long tno = Long.parseLong(req.getParameter("tno"));
            System.out.println("tno: " + tno);

            TodoDTO dto = todoService.get(tno);
            req.setAttribute("dto", dto);
            req.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(req, res);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Post
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            TodoVO todoVO = new TodoVO().builder()
                    .tno(Long.parseLong(req.getParameter("tno")))
                    .title(req.getParameter("title"))
                    .dueDate(LocalDate.parse(req.getParameter("dueDate")))
                    .finished(Boolean.parseBoolean(req.getParameter("finished")))
                    .build();

            todoService.update(todoVO);
            res.sendRedirect("/todo/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
