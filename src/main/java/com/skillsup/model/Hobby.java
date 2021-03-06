package com.skillsup.model;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 4:36 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Hobby {
    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    public int getId();

    public void setId(int id);

    public Set<Contact> getContacts();

    public void setContacts(Set<Contact> contacts);
}
