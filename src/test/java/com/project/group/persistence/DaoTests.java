package com.project.group.persistence;

import com.project.group.entity.Message;
import com.project.group.persistence.MessageDao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.engine.transaction.spi.LocalStatus;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Synchronization;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author afaherty
 * @version 1.0 on 11/24
 */


/**
 * Unit tests for MessageDao
 */
public class DaoTests {

    private SessionFactory sessionFactory;
    private Session session;
    Configuration config;


    @Before
    /**
     * Create a connection to the database for Hibernate
     */
    public void before() {

        config = new Configuration();
        config.addAnnotatedClass(MessageDao.class);
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/fortuneTest");

        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
                config.getProperties()).buildServiceRegistry();

        sessionFactory = config.buildSessionFactory(registry);
        session = sessionFactory.openSession();

    }

    @Test
    public void addMessage() {

        try {
            MessageDao dao = new MessageDao();
            Message message = new Message(0, "testing addMessage");

            assertEquals("testing addMessage", message.getMyMessage());
            assertNotNull("integer is null", message.getId());
            dao.deleteMyMessageById(message.getId());
        } catch (HibernateException e) {
            assertNull(e);
        }
    }


    @Test
    public void addOrUpdateUserMessage() {

        MessageDao dao = new MessageDao();
        Message message = new Message(0, "testing update message");

        try {
            dao.addMessage(message);

            assertEquals("testing update message", message.getMyMessage());

            dao.addOrUpdateUserMessage(message.getId(), "updating message");

            assertEquals("updating message", String.valueOf(dao.getMessage(message.getId())));
            assertNotNull("integer is null", message.getId());

            dao.deleteMyMessageById(message.getId());
        } catch (HibernateException e) {
            assertNull(e);
        }
    }

    @Test
    public void getMyMessageList() {

        try {

            MessageDao dao = new MessageDao();
            List<Message> list = new ArrayList<Message>();

            list = dao.getMyMessageList();

            int i; //reference to count of messages in database
            for (i = 0; i < list.size(); i++) {
                i++;
            }

            assertNotNull("list is not null", list.size());
            assertTrue(list.size() == i);

        } catch (HibernateException e) {
            assertNull(e);
        }
    }

    @Test
    public void deleteMyMessageById() {

        try {
            MessageDao dao = new MessageDao();
            Message message = new Message(0, "testing deleteMessage");

            assertEquals("testing deleteMessage", message.getMyMessage());
            assertNotNull("integer is null", message.getId());
            dao.deleteMyMessageById(message.getId());
            assertNull("testing deleteMessage", dao.getMessage(message.getId()));
        } catch (HibernateException e) {
            assertNull(e);
        }
    }

    @Test
    public void getMessage() {

        try {

            MessageDao dao = new MessageDao();
            Message message = new Message(0, "testing getMessage");

            dao.getMessage(message.getId());

            assertEquals("testing getMessage", message.getMyMessage());
            assertFalse(message.getId() == 4);
        } catch (HibernateException e) {
            assertNull(e);

        }
    }
}
