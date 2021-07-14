package pl.sda.sapiens5.journal.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double a = Double.parseDouble(req.getParameter("a"));
        double b = Double.parseDouble(req.getParameter("b"));
        req.setAttribute("a", a);
        req.setAttribute("b", b);
        getServletContext().getRequestDispatcher("/calculator.jsp").forward(req,resp);
    }
}
