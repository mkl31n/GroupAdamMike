package com.project.group.entity;


/**
 * @author  michaelklein, afaherty
 * @version 1.0 11/15/15.
 */
public class Message {

    private int id;
    private String myMessage;

    /**
     * zero arg constructor
     */
    public  Message() {

    }

    /**
     *
     * @param id ref to myMessage id number
     * @param myMessage ref to myMessage String
     */
    public Message(int id, String myMessage) {
        this.id = id;
        this.myMessage = myMessage;
    }

    /**
     * recieve value of myMessage var
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * set id value
     * @param id int value of id var
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * recieve value of myMessage var
     * @return myMessage
     */
    public String getMyMessage() {
        return myMessage;
    }

    /**
     * set value of myMessage var
     * @param myMessage string content containing myMessage
     */
    public void setMyMessage(String myMessage) {
        this.myMessage = myMessage;
    }

    public String toString() {
        return System.lineSeparator() +
                "Id, Message: " + " "
                + id + " "
                + myMessage;
    }
}

