package com.example.w2.todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="TodoModifyController", urlPatterns ="/todo/modify")
public class TodoModifycontroller extends HttpServlet {

    // Get
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/todo/modify.jsp");
        dispatcher.forward(req,res);
    }

    // Post
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");

        res.sendRedirect("/todo/list");
    }
}
