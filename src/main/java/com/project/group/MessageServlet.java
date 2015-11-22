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
 * Created by michaelklein on 11/15/15.
 */
public class MessageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException {

        ServletContext context = getServletContext();
        MessageDao attribute = (MessageDao)context.getAttribute("dao");
        Random random = new Random();

        Message returnedMessage = (Message) attribute.getMyMessageList().get(random.nextInt(attribute.getMyMessageList().size()));

        // get one Message
        System.out.println("Getting one record");
        System.out.println(returnedMessage);
        System.out.println();

        HttpSession session = request.getSession();

        session.setAttribute("returnedMessage", returnedMessage);

        String url = "/message.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
