package com.example.w2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class LifeCycleServlet extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        System.out.println("nan init ya! ban ga ban ga");
        super.init();
    }

    public void destroy() {
        System.out.println("Destroy Called : You are fired!");
        super.destroy();
    }

    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("Service Called");
        super.service(req, res);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("doGet Called");
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + req.getParameter("name") + "11</h1>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("doPost Called");
    }
}
