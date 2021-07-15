package pl.sda.sapiens5.journal;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class BasicServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter writer = servletResponse.getWriter();
        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("UTF-8");
        writer.println("Hello from servlet!!");
        writer.flush();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
