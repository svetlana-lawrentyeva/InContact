package com.skillsup.model.impl;

import com.skillsup.model.Hobby;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class HobbyImpl implements Hobby {
    private int id;
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
