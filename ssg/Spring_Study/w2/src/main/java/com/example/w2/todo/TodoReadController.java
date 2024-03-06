package com.example.w2.todo;

import com.example.w2.todo.dto.TodoDTO;
import com.example.w2.todo.todoService.TodoServiceEnum;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="TodoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {

    // Get
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("/todo/read");
        Long tno = Long.parseLong(req.getParameter("tno"));
        System.out.println(tno);
        TodoDTO dto = TodoServiceEnum.INSTANCE.get(tno);

        req.setAttribute("dto", dto);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/read.jsp");
        dispatcher.forward(req, res);
    }

}
