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
import java.util.List;

@WebServlet(name="TodoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

    // Get
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("/todo/list");

        List<TodoDTO> dtoList = TodoServiceEnum.INSTANCE.getList();

//        String title = req.getParameter("title");
//        String date = req.getParameter("date");
//
//        // Set attributes for the JSP
//        req.setAttribute("title", title);
//        req.setAttribute("date", date);

        req.setAttribute("list", dtoList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/list.jsp");
        dispatcher.forward(req, res);
    }

}
