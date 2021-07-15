package pl.sda.sapiens5.journal.servlet;

import pl.sda.sapiens5.journal.repository.JournalRepository;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "list-servlet", value = "/list")
public class ListServlet extends HttpServlet {

    @Inject
    private JournalRepository repository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dateString = request.getParameter("date");
        LocalDate date = LocalDate.parse(dateString);
        request.setAttribute("list", repository.findByDate(date));
        getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] names = request.getParameterValues("names");
        String date = request.getParameter("date");
        LocalDate localDate = LocalDate.parse(date);
        repository.save(names, localDate);
        response.sendRedirect("list?date="+localDate);
    }
}
