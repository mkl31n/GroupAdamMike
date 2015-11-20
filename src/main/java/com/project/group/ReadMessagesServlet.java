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
import java.util.List;

@WebServlet(
        name = "ReadMessagesServlet",
        urlPatterns = { "/ReadMessagesServlet" }
)

/**
 * Created by michaelklein on 11/19/15.
 */
public class ReadMessagesServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        MessageDao attribute = (MessageDao)context.getAttribute("dao");

        String stype = request.getParameter("stype");
        String term = request.getParameter("term");

        if (term == "") {
            term = "0";
        }

        HttpSession session = request.getSession();

        int i = Integer.parseInt(term);

        if (stype.equals("read_all")) {
            List read = attribute.getMyMessageList();
            session.setAttribute("readList", read);
        } else if (stype.equals("delete")) {
            attribute.deleteMyMessageById(i);
        } else {
            Message read = attribute.getMyMessage(i);
            session.setAttribute("readMessage", read);
        }

        response.sendRedirect("/MessageReadServlet");
    }
}
