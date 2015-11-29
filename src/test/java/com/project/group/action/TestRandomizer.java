package com.project.group.action;

import com.project.group.entity.Message;
import com.project.group.persistence.MessageDao;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Unit tests for Randomizer
 * @author afaherty
 * @version 1.0 on 11/29/2015
 */
public class TestRandomizer {

    Randomizer randomizer;
    MessageDao dao = new MessageDao();

    @Before
    public void before() {


    }

    @Test
    public void testRandomMessage() {

        randomizer = new Randomizer();
        Message message = randomizer.randomMessage();
        String test = String.valueOf(dao.getMessage(message.getId()));

        assertEquals(test, message.toString()); //checks message value is equal to what is in database
        assertFalse("message not in database", message.equals("this messagge is NoT !n th3 d@t@b@53"));
    }
}
