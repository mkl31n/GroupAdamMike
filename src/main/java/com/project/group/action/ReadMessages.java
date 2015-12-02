package com.project.group.action;

import com.project.group.entity.Message;
import com.project.group.persistence.MessageDao;

import java.util.List;

/**
 * Reads user messages
 * @author afaherty
 * @version 1.0 on 12/1/2015
 */
public class ReadMessages {

    MessageDao dao;

    /**
     * method to retrieve a list of all messages in database
     * @return read
     */
    public List readAll() {

        dao = new MessageDao();
        List read = dao.getMyMessageList();

        return read;
    }

    /**
     * deletes a message from the database based on the users params
     * @param i refrence to the message id to be deleted
     * @return dao
     */
    public MessageDao deleteThisMessage(int i) {

        dao = new MessageDao();
        dao.deleteMyMessageById(i);

        return dao;
    }

    /**
     * recieves message from database based on users params
     * @param i reference to the message id requested
     * @return message
     */
    public Message readSelectMessage(int i) {

        Message message;
        dao = new MessageDao();
        message = dao.getMessage(i);

        return message;
    }


}
