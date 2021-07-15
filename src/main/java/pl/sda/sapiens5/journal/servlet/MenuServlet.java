package pl.sda.sapiens5.journal.servlet;

import org.jboss.weld.context.ejb.Ejb;
import pl.sda.sapiens5.journal.repository.JournalRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "menu-servlet", value = "/journal")
public class MenuServlet extends HttpServlet {

    //@Inject - wstrzykiwanie przez pole
    private JournalRepository repository;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dates", repository.findAllDates());
        getServletContext().getRequestDispatcher("/menu.jsp").forward(req, resp);
    }

    @Inject //wstrzykiwanie przez metodę
    public void setRepository(JournalRepository repository) {
        this.repository = repository;
    }
}
