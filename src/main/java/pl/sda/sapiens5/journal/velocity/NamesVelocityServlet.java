package pl.sda.sapiens5.journal.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/velocity")
public class NamesVelocityServlet extends VelocityViewServlet {
    @Override
    protected Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context ctx) {
        if (request.getMethod().toUpperCase().equals("GET")){
            List<String> names = Arrays.asList("ALA", "OLA","BEATA");
            ctx.put("names", names);
            return getTemplate("names.vm");
        } else{
            return getTemplate("error.vm");
        }
    }
}
