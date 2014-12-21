package com.skillsup.model.impl;

import com.skillsup.model.Contact;
import com.skillsup.model.Message;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageImpl implements Message {
    private int id;
    private LocalDateTime date;
    private Contact from;
    private Contact to;
    private String content;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Contact getFrom() {
        return from;
    }

    public void setFrom(Contact from) {
        this.from = from;
    }

    public Contact getTo() {
        return to;
    }

    public void setTo(Contact to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
