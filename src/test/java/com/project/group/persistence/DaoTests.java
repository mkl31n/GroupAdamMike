package com.project.group.persistence;

import com.project.group.entity.Message;
import com.project.group.persistence.MessageDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    public void addMessage() throws Exception {

        MessageDao dao = new MessageDao();
        Message message = new Message(0, "testing addMessage");

        assertEquals("testing addMessage", message.getMyMessage());
        assertNotNull("integer is null",message.getId());

        dao.deleteMyMessageById(message.getId());
    }

   // @Test
    /*public void addOrUpdateUserMessage() {
        MessageDao dao = new MessageDao();
        Message message = new Message(0, "testing addOrUpdateUserMessage");
        System.out.println("id: " + message.getId());
        assertEquals("testing addOrUpdateUserMessage", message.getMyMessage());

        dao.addOrUpdateUserMessage(0, "updating message");

        assertEquals("updating message", message.getMyMessage());
        assertNotNull("integer is null",message.getId());

        dao.deleteMyMessageById(message.getId());
    }*/

    @Test
    public void getMyMessageList() {

    }

    @Test
    public void deleteMyMessageById() {

    }
}
