package pl.sda.sapiens5.journal.servlet;

import pl.sda.sapiens5.journal.JournalRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet(name = "list-servlet", value = "/list")
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String dateString = request.getParameter("date");
        String timeString = request.getParameter("time");
        JournalRepository repository = JournalRepository.getInstance();
        LocalDate date = LocalDate.parse(dateString);
        repository.findByDate(date).forEach(writer::println);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
