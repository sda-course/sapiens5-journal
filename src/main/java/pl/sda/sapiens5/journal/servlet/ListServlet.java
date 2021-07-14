package pl.sda.sapiens5.journal.servlet;

import pl.sda.sapiens5.journal.JournalRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "list-servlet", value = "/list")
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dateString = request.getParameter("date");
        JournalRepository repository = JournalRepository.getInstance();
        LocalDate date = LocalDate.parse(dateString);
        request.setAttribute("list", repository.findByDate(date));
        getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
