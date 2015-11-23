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
 * @author michaelklein
 * @version 1.0 on 11/19/15.
 */
public class ReadMessagesServlet extends HttpServlet {

    private HttpSession session;
    private MessageDao attribute;

    /**
     * Retrieves random message from database to display to the user as a fortune
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if there is a Servlet error
     * @throws IOException if there is an input/output error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        attribute = (MessageDao)context.getAttribute("dao");

        String stype = request.getParameter("stype");
        String term = request.getParameter("term");

        if (term == "") {
            term = "0";
        }

        session = request.getSession();

        performSearch(term, stype);

        redirectUserToMessageRead(response);
    }

    /**
     * Redirects user to results page
     * @param response HttpServletResponse objecft
     * @throws IOException if there ins an input/output error
     */
    public void redirectUserToMessageRead(HttpServletResponse response) throws IOException {

        String url = "/MessageReadServlet";
        response.sendRedirect(url);
    }


    /**
     * Performs an action on the database based on radio button selected
     * @param term reference to search term text box on messageRead.jsp
     * @param stype reference to radio button to select search type
     */
    public void performSearch(String term, String stype) {

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
    }
}
