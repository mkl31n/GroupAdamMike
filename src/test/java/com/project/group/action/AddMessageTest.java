package com.project.group.action;

import com.project.group.entity.Message;
import com.project.group.persistence.MessageDao;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for AddMessage
 * @author afaherty
 * @version 1.0 on 12/1/2015
 */
public class AddMessageTest {

    @Test
    public void addMessageData() {

        MessageDao dao = new MessageDao();
        Message message = new Message(0, "Hello Test World");
        AddMessage add = new AddMessage();

        //
        String user_message = String.valueOf(message.getMyMessage());
        dao.addMessage(message); //add the original message object to db for sloppy cleanup at the end

        // test the method
        add.addMessageData(user_message);

        //test
        assertNotNull(add);
        assertTrue("strings do not match", user_message.equals("Hello Test World"));

        //remove from database
        dao.deleteMyMessageById(message.getId() + 1);
        dao.deleteMyMessageById(message.getId());
    }

}
