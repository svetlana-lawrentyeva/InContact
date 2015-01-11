package com.skillsup.model.impl;

import com.skillsup.model.Contact;
import com.skillsup.model.Hobby;

import javax.persistence.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="hobbies")
public class HobbyImpl implements Hobby {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "hobbies", fetch = FetchType.LAZY)
    private Set<Contact>contacts;

    //===============================================================================

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

    public Set<Contact> getContacts() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setContacts(Set<Contact> contacts) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
