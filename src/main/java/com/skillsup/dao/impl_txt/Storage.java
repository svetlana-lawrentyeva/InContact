package com.skillsup.dao.impl_txt;

import com.skillsup.model.Contact;
import com.skillsup.model.Hobby;
import com.skillsup.model.Message;
import com.skillsup.model.Place;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 11:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Storage {

    @Autowired
    private
    Object[]storage;

    @PostConstruct
    public void init(){
        //storage = new Object[4];
        getStorage()[0] = new LinkedList<Contact>();
        getStorage()[1] = new LinkedList<Hobby>();
        getStorage()[2] = new LinkedList<Place>();
        getStorage()[3] = new LinkedList<Message>();
    }

    public LinkedList<Contact>getContacts(){
        return (LinkedList<Contact>) getStorage()[0];
    }

    public LinkedList<Hobby> getHobbies() {
        return (LinkedList<Hobby>) getStorage()[1];
    }

    public LinkedList<Place> getPlaces() {
        return (LinkedList<Place>) getStorage()[2];
    }

    public LinkedList<Message> getMessages() {
        return (LinkedList<Message>) getStorage()[3];
    }


    public Object[] getStorage() {
        return storage;
    }

    public void setStorage(Object[] storage) {
        this.storage = storage;
    }
}
