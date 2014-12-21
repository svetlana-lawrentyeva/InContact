package com.skillsup.dao.impl_txt;

import com.skillsup.dao.HobbyDao;
import com.skillsup.model.Contact;
import com.skillsup.model.Hobby;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class HobbyDaoImpl implements HobbyDao {
    @Autowired
    private Storage storage;


    public void addHobby(Hobby hobby){
        getStorage().getHobbies().add(hobby);
    }
    public Set<Contact> getAllContactsWithHobby(Hobby hobby){
        Set<Contact> resultContacts = new HashSet<Contact>();

        LinkedList<Contact>contacts = getStorage().getContacts();
        for(Contact contact:contacts){
            Set<Hobby>hobbies = contact.getHobbies();
            for(Hobby h:hobbies){
                if(h.equals(hobby))
                    resultContacts.add(contact);
            }
        }

        return resultContacts;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
