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

        PrintWriter writer = response.getWriter();
        String dateString = request.getParameter("date");
        String timeString = request.getParameter("time");
        JournalRepository repository = JournalRepository.getInstance();
        LocalDate date = LocalDate.parse(dateString);
        repository.findByDate(date).forEach(writer::println);
        for(Cookie cookie: request.getCookies()){
            if(cookie.getName().equals("color")){
                writer.println("Cookie color: " + cookie.getValue());
            }
            if(cookie.getName().equals("JSESSIONID")){
                writer.println("ID sesji: " + cookie.getValue());
            }
        }

        HttpSession session = request.getSession();
        List<String> visited = (List<String>) session.getAttribute("visited");
        if (visited == null) {
            writer.println("O, jesteś pierwszy raz na stronie");
        } else{
            writer.println("Odwiedziłeś już strony: " + visited);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
