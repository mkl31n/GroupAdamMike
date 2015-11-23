package com.project.group;

import com.project.group.entity.Message;
import com.project.group.persistence.MessageDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "AddMessageServlet",
        urlPatterns = { "/AddMessageServlet" }
)

/**
 * Allows admin to add new message to database
 * @author michaelklein
 * @version 1.0 on 11/19/15.
 */
public class AddMessageServlet extends HttpServlet{

    /**
     * Adds new message to database
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if there is a Servlet error
     * @throws IOException if there is an input/output error
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        MessageDao attribute = (MessageDao)context.getAttribute("dao");

        String user_message = request.getParameter("user_message");

        Message message = new Message(0, user_message);

        int success = attribute.addMessage(message);

        HttpSession session = request.getSession();

        if (success > 0) {
            session.setAttribute("AddMessage",
                    "Success. Row inserted.");
            System.out.print(success);
        } else {
            session.setAttribute("AddMessage",
                    "Row NOT inserted.");
            System.out.print(success);
            System.out.print("Attribute not found.");
        }

        redirectUserToMessageAdd(response);
    }

    /**
     * Redirects user to messageAdd.jsp servlet
     * @param response HttpServletResponse objecft
     * @throws IOException if there ins an input/output error
     */
    public void redirectUserToMessageAdd(HttpServletResponse response) throws IOException {

        String url = "/MessageAddServlet";
        response.sendRedirect(url);
    }
}
