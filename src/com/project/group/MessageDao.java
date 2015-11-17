package com.project.group;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by michaelklein on 11/16/15.
 */
public class MessageDao {

    // Need to correct method to return all messages
    public void getAllMessages() {
        Message myMessage = new Message();
        int count = 0;
        ResultSet resultSet = null;

        Connection connection = Database.getInstance().getConnection();
        Statement selectStatement = null;

        try {
            selectStatement = connection.createStatement();

            String queryString = "SELECT * FROM message";

            resultSet = selectStatement.executeQuery(queryString);

            while (resultSet.next()) {
                myMessage.setFortune(resultSet.getString("text"));
                ++count;
            }

            System.out.println("rows affected: " + count);
            System.out.println(myMessage.getFortune());

        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
    }

    // We need a method that will generate myNumber based on how many entries are in the database
    public void getMessage(int myNumber) {
        Message myMessage = new Message();
        int count = 0;
        ResultSet resultSet = null;

        Connection connection = Database.getInstance().getConnection();
        Statement selectStatement = null;

        try {
            selectStatement = connection.createStatement();

            String queryString = "SELECT text FROM message WHERE id = " + myNumber;

            resultSet = selectStatement.executeQuery(queryString);

            while (resultSet.next()) {
                myMessage.setFortune(resultSet.getString("text"));
                ++count;
            }

            System.out.println("rows affected: " + count);
            System.out.println(myMessage.getFortune());

        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
    }

    // Need to correct method to insert
    public void insertMessage() {
        Message myMessage = new Message();
        int count = 0;
        ResultSet resultSet = null;

        Connection connection = Database.getInstance().getConnection();
        Statement selectStatement = null;

        try {
            selectStatement = connection.createStatement();

            String queryString = "SELECT text FROM message WHERE id = " + myNumber;

            resultSet = selectStatement.executeQuery(queryString);

            while (resultSet.next()) {
                myMessage.setFortune(resultSet.getString("text"));
                ++count;
            }

            System.out.println("rows affected: " + count);
            System.out.println(myMessage.getFortune());

        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
    }

    // Need to correct method to delete
    public void deleteMessage(int myNumber) {
        Message myMessage = new Message();
        int count = 0;
        ResultSet resultSet = null;

        Connection connection = Database.getInstance().getConnection();
        Statement selectStatement = null;

        try {
            selectStatement = connection.createStatement();

            String queryString = "SELECT text FROM message WHERE id = " + myNumber;

            resultSet = selectStatement.executeQuery(queryString);

            while (resultSet.next()) {
                myMessage.setFortune(resultSet.getString("text"));
                ++count;
            }

            System.out.println("rows affected: " + count);
            System.out.println(myMessage.getFortune());

        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
    }
}
