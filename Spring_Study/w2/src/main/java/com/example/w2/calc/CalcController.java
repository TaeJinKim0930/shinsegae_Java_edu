package com.example.w2.calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Flow : localhost:8090/calc/input(InputController) 에서 값 입력 ->
 *              -> WEB-INF/calc/input.jsp 에서 처리
 *              -> localhost:8090/calc/makeResult(CalcController)를 통해서 output 출력
 *                  -> localhost:8090/index 로 송출 (아직 index 페이지 구현x)
 */
@WebServlet(name="CalcController", urlPatterns = "/calc/makeResult")
public class CalcController extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        System.out.println("num1 : " + num1 + ", num2 : " + num2);

        res.sendRedirect("/index");


    }
}
