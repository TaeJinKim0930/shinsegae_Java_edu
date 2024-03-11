package com.example.jdbcex.controller.todo;

import com.example.jdbcex.dto.TodoDTO;
import com.example.jdbcex.todoService.TodoServiceEnum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="TodoListController", urlPatterns = "/todo/list")
public class TodoListController2 extends HttpServlet {
    // 1. todoService 객체 생성
    private TodoServiceEnum todoService = TodoServiceEnum.INSTANCE;

    // Get
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("/todo/list");

        try {
            List<TodoDTO> dtoList = todoService.listAll();
//            dtoList.forEach(System.out::println);
            req.setAttribute("dtoList", dtoList);
            req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, res);
        } catch (Exception e) {
            throw new ServletException("List Error :)");
        }
    }

    // Post
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("해당 리스트정보 페이지로 이동");
        String tno = req.getParameter("tno");

        res.sendRedirect("/todo/read?tno=" + tno);
    }

}
