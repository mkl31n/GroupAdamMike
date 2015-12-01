package com.project.group.action;

import com.project.group.persistence.MessageDao;

import java.util.List;

/**
 * Reads user messages
 * @author afaherty
 * @version 1.0 on 12/1/2015
 */
public class ReadMessages {

    /**
     * method to retrieve a list of all messages in database
     * @return read
     */
    public List readAll() {

        MessageDao dao = new MessageDao();
        List read = dao.getMyMessageList();

        return read;
    }


}
