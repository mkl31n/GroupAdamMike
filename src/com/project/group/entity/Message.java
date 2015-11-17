package com.project.group.entity;


/**
 * @author  michaelklein, afaherty
 * @version 1.0 11/15/15.
 */
public class Message {

    private int id;
    private String fortune;

    /**
     * zero arg constructor
     */
    public  Message() {

    }

    /**
     *
     * @param id ref to fortune id number
     * @param fortune ref to fortune String
     */
    public Message(int id, String fortune) {

        this.id = id;
        this.fortune = fortune;
    }

    /**
     * recieve value of fortune var
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
     * recieve value of fortune var
     * @return fortune
     */
    public String getFortune() {
        return fortune;
    }

    /**
     * set value of fortune var
     * @param fortune string content containing fortune
     */
    public void setFortune(String fortune) {
        this.fortune = fortune;
    }
}

