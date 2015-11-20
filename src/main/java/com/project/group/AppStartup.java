package com.project.group;

import com.project.group.persistence.MessageDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/startup" },
        loadOnStartup = 1
)

/**
 * Created by michaelklein on 11/19/15.
 */
public class AppStartup extends HttpServlet{
    private MessageDao dao;

    public void init() throws ServletException {
        dao = new MessageDao();
        System.out.println("The MessageDao is loaded!");
        ServletContext context = getServletContext();
        context.setAttribute("dao", dao);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
