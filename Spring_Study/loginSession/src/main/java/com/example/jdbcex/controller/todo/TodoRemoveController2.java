package com.example.jdbcex.controller.todo;

import com.example.jdbcex.todoService.TodoServiceEnum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="TodoRemoveController", urlPatterns ="/todo/remove")
public class TodoRemoveController2 extends HttpServlet {
    private TodoServiceEnum todoService = TodoServiceEnum.INSTANCE;

    // Post
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            todoService.delete(Long.parseLong(req.getParameter("tno")));
            res.sendRedirect("/todo/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
