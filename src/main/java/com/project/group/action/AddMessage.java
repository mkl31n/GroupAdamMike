package com.project.group.action;

import com.project.group.entity.Message;
import com.project.group.persistence.MessageDao;

/**
 * Action class to add a message to database
 * @author afaherty
 * @version 1.0 on 12/*1/2015
 */
public class AddMessage {

    /**
     * Adds message added to database by admin on webpage
     * @param user_message reference to the message user input
     * @return message
     */
    public Message addMessageData(String user_message) {

        MessageDao dao = new MessageDao();
        Message message = new Message(0, user_message);

        dao.addMessage(message);

        return message;

    }
}
