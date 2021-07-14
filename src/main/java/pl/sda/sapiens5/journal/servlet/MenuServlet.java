package pl.sda.sapiens5.journal.servlet;

import pl.sda.sapiens5.journal.JournalRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "menu-servlet", value = "/journal")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JournalRepository repository = JournalRepository.getInstance();
        req.setAttribute("dates", repository.findAllDates());
        getServletContext().getRequestDispatcher("/menu.jsp").forward(req, resp);
    }
}
