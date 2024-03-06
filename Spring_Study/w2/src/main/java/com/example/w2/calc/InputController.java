package com.example.w2.calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * GET 방식으로 /calc/input 경로로 호출할때 처리되는 컨트롤러이다.
 */
@WebServlet(name = "inputContoller", urlPatterns = "/calc/input")
public class InputController extends HttpServlet {

    // get
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("InputController ...doGet ...reqeust");

        // servlet 에 들어온 것을 다른 곳으로 보내주는 것 (버스같은 개념)
        // hidden 시키는거라서 localhost:8090/WEB-INF/calc/input.jsp 주소로 접근이 불가능함. 이 컨트롤러를 통해서만 접근이 가능.
        // ==> http://localhost:8090/calc/input 로만 접근이 가능
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/calc/input.jsp");
        dispatcher.forward(req, res);
    }
}
