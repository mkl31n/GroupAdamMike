package com.project.group;

import com.project.group.entity.Message;
import com.project.group.persistence.MessageDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet(
        name = "MessageServlet",
        urlPatterns = { "/MessageServlet" }
)
/**
 * Redirects user to message.jsp
 * @author michaelklein
 * @version 1.0 11/15/15.
 */
public class MessageServlet extends HttpServlet {

    MessageDao attribute;
    HttpSession session;

    /**
     * Retrieves random message from database to display to the user as a fortune
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if there is a Servlet error
     * @throws IOException if there is an input/output error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException {

        Randomizer randomizer = new Randomizer();

        ServletContext context = getServletContext();
        attribute = (MessageDao)context.getAttribute("dao");

        session = request.getSession();

        Message message = randomizer.randomMessage();
        session.setAttribute("returnedMessage", message);

        forwardUser(request, response);
    }

    /**
     * Forwards user to message.jsp
     * @param request HttpServletRequest object
     * @param response HttpServletResponse ojbect
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input/output error
     */
    public void forwardUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/message.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
