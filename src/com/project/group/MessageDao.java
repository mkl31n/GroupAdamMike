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

    public List<Message> getAllMessages() throws SQLException {

        List<Message> myMessages = new ArrayList<Message>();

        Connection connection = Database.getInstance().getConnection();

        String sql = "SELECT * FROM message";

        Statement selectStatement = connection.createStatement();

        ResultSet results = selectStatement.executeQuery(sql);

        while (results.next()) {
            String storedMessage = results.getString("text");

            Message myMessage = new Message();
            myMessage.setFortune(storedMessage);
            myMessages.add(myMessage);
        }

        results.close();
        selectStatement.close();

        return myMessages;
    }

    public void insertMessage() {

        Message myMessage = new Message();

        String fortune = "Test to See if this Works!!!!";

        try {
            Connection connection = Database.getInstance().getConnection();

            String sql = "INSERT INTO message VALUES (fortune)";
            Statement selectStatement = connection.createStatement();

            int rowsAffected = selectStatement.executeUpdate(sql);

            System.out.println("rows affected: " + rowsAffected);

        } catch (SQLException sqlException) {
            System.err.println("Error in connection.ecting to database "
                    + sqlException);
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
    }
}
