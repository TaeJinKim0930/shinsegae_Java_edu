package com.example.w2.todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="TodoRemoveController", urlPatterns ="/todo/remove")
public class TodoRemoveController extends HttpServlet {

    // Post
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        res.sendRedirect("/todo/list");
    }
}
