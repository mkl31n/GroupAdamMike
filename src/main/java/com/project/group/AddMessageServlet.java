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
 * Created by michaelklein on 11/19/15.
 */
public class AddMessageServlet extends HttpServlet{

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

        response.sendRedirect("/MessageAddServlet");
    }
}
