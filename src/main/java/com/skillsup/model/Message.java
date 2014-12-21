package com.skillsup.model;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 5:00 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Message {
    LocalDateTime getDate();

    void setDate(LocalDateTime date);

    Contact getFrom();

    void setFrom(Contact from);

    Contact getTo();

    void setTo(Contact to);

    String getContent();

    void setContent(String content);

    public int getId();

    public void setId(int id);
}
