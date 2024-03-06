package com.example.w2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * extends HttpServlet : 웹에서 동작하는 클래스로 만들어 주는 아이
 *
 * @WebServlet : Servlet 에 경로를 지정을 해주는 아이
 */
@WebServlet(name = "myServlet", urlPatterns = "/my")
public class myServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println(
                "<html>" +
                    "<body>" +
                        "<h1>hihi</h1>" +
                    "</body>" +
                "</html>"
        );
    }

    

}
