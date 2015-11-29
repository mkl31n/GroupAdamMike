package com.project.group;

import com.project.group.entity.Message;
import com.project.group.persistence.MessageDao;

import java.util.Random;

/**
 * Generates a random message from database
 * @author afaherty
 * @version 1.0 on 11/29/2015
 */

public class Randomizer {
    /**
     * retrieves a random message from database. Sets message in session.
     *
     * @return random message
     */
    public Message randomMessage() {
        Random random = new Random();
        MessageDao attribute = new MessageDao();
        return (Message) attribute.getMyMessageList().get(random.nextInt(
                attribute.getMyMessageList().size()));


    }
}
