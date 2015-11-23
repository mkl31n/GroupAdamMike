package com.project.group;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "MessageReadServlet",
        urlPatterns = { "/MessageReadServlet" }
)

/**
 * @author michaelklein
 * @version 1.0 on 11/19/15.
 */
public class MessageReadServlet extends HttpServlet{

    /**
     * Forwards admin to messageRead.jsp. Receive session data
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if there is a Servlet error
     * @throws IOException if there is an input/output error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/messageRead.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

        HttpSession session = request.getSession();
        session.invalidate();
    }


}
