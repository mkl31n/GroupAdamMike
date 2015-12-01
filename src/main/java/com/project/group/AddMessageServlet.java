package com.project.group;

import com.project.group.action.AddMessage;
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

        receiveParameter(request);

        createSession(request);

        redirectUserToMessageAdd(response);
    }

    /**
     * Receives values of jsp text box
     * @param request HttpServletRequest object
     */
    public void receiveParameter(HttpServletRequest request) {

        String user_message = request.getParameter("user_message");
        addUserMessage(user_message);
    }

    /**
     * Instantiates an AddMessage object
     *
     */
    public void addUserMessage(String user_message)  {

        AddMessage addMessage = new AddMessage();
        addMessage.addMessageData(user_message);
    }

    /**
     * recieve session
     * @param request HttpServletRequest object
     */
    public void createSession(HttpServletRequest request) {

        HttpSession session = request.getSession();
        writeSuccessSessionMessage(session);
    }

    /**
     * Write a message to web page for successful message add
     * @param session HttpSession object
     */
    public void writeSuccessSessionMessage(HttpSession session) {

        String success = "Sucess. Row Inserted";
        session.setAttribute("AddMessage", success);
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
