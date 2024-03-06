package com.example.w2.todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="TodoRegisterController", urlPatterns ="/todo/register")
public class TodoRegisterController extends HttpServlet {

    // Get
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("입력 화면을 볼 수 있도록 구성");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        dispatcher.forward(req, res);
    }

    // Post
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("입력을 처리하고 목록 페이지로 이동");
        String title = req.getParameter("title");
        String date = req.getParameter("date");

        req.setAttribute("title", title);
        req.setAttribute("date", date);

        res.sendRedirect("/todo/list?title=" + title + "&date=" + date);
    }
}
