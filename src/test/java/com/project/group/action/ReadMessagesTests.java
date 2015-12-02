package com.project.group.action;

import com.project.group.entity.Message;
import com.project.group.persistence.MessageDao;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Test class for ReadMessages action
 * @author afaherty
 * @version 1.0 on 12/1/2015
 */
public class ReadMessagesTests {

    ReadMessages read;
    Message message;
    MessageDao dao;

    @Test
    /**
     * tests the read all action in the ReadMessage class
     */
    public void readAll() {

        read = new ReadMessages();
        read.readAll();

    }

    @Test
    /**
     * tests the delete action in the ReadMessage class
     */
    public void deleteThisMessage() {

        dao = new MessageDao();
        message = new Message(0, "test delete");
        ReadMessages read = new ReadMessages();
        dao.addMessage(message);

        //write tests here

        read.deleteThisMessage(message.getId());
    }

    @Test
    /**
     * tests the read message action in the ReadMessage class
     */
    public void readSelectMessage() {

        read = new ReadMessages();
        message = new Message(0, "reading test");
        dao = new MessageDao();

        dao.addMessage(message);

        read.readSelectMessage(message.getId());

        // write assertions here


        dao.deleteMyMessageById(message.getId());
    }
}
