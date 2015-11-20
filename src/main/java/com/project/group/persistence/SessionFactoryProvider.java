package com.project.group.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author afaherty
 * @version 1.0 11/17/2015
 */

public class SessionFactoryProvider {

    private static SessionFactory sessionFactory;

    /**
     * Instantiates a new SessionFactory object. Loads config details
     */
    public static void createSessionFactory() {

        Configuration config = new Configuration();

        //use mappings and properties specified in hibernate.cfg.xml
        config.configure();

        //build on ServiceRegistry inst. Apply value of config var
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(
                config.getProperties()).buildServiceRegistry();

        //instantiate new SessionFactory using properties and mappings
        sessionFactory = config.buildSessionFactory(registry);
    }

    /**
     * Instantiates a SessionFactory object if none exists
     * @return sessionFactory
     */
    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            createSessionFactory();
        }

        return sessionFactory;
    }
}