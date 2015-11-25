package com.project.group.persistence;

import com.project.group.persistence.MessageDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author afaherty
 * @version 1.0 on 11/24
 */


/**
 * Unit tests for MessageDao
 */
public class MessageDaoTest {

    private SessionFactory sessionFactory;
    private Session session;

    @Before
    /**
     * Create a connection to the database for Hibernate
     */
    public void before() {

        Configuration config = new Configuration();
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

    }

    @Test
    public void addOrUpdateUserMessage() {

    }

    @Test
    public void getMyMessageList() {

    }

    @Test
    public void deleteMyMessageById() {

    }
}
