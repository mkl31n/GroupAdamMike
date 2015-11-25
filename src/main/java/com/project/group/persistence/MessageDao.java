package com.project.group.persistence;

import com.project.group.entity.Message;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author michaelklein
 * @version 1.0 on 11/16/15.
 */
public class MessageDao {

    /** Method to CREATE a myMessage in the persistence
     *  @param myMessage The myMessage to be added
     *
     * **/
    public Integer addMessage(Message myMessage) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer id = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(myMessage);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    /**
     * Method to CREATE or UPDATE a myMessage in the persistence.
     * If an id of 0 is passed in, a new myMessage entry will be created.
     * If an id of an existing record is passed in, the myMessage is updated.
     *
     * @param MessageID reference to message id number
     * @param messageString The UserRole to be added or created
     **/
   /* public void addOrUpdateUserMessage(int MessageID, String messageString) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer id = null;
        try {
            tx = session.beginTransaction();
            Message message = (Message)session.get(Message.class, MessageID);
            message.setMyMessage(messageString);
            session.update(message);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }*/
    /**
     * Method to list all userRoles in the persistence
     * @return all myMessages
     **/
    public List getMyMessageList() {
        List<Message> myMessages = new ArrayList<Message>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        // Criteria is used to narrow searches.
        // In this case we are using the simplest criteria to get all Message rows
        Criteria criteria=session.createCriteria(Message.class);
        try {
            myMessages = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return myMessages;
    }

    /**
     * Method to delete a myMessage
     * @param id of the myMessage to be deleted
     **/
    public void deleteMyMessageById(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Message myMessage = (Message)session.get(Message.class, id);
            if (myMessage != null) {
                session.delete(myMessage);
            }
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /**
     * Method to retrieve a myMessage by id
     * @param id of the myMessage to be retrieved
     * @return myMessage matching the id requested
     **/
    public Message getMessage(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Message myMessage = null;
        try {
            myMessage = (Message)session.get(Message.class, id);
            if (myMessage != null) {
                return myMessage;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return myMessage;
    }
}
