package com.skillsup.dao.impl_txt;

import com.skillsup.dao.ContactDao;
import com.skillsup.model.Contact;
import com.skillsup.model.Hobby;
import com.skillsup.model.Place;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContactDaoImpl implements ContactDao {

    @Autowired
    private Storage storage;

    public void addContact(Contact contact){
        storage.getContacts().add(contact);
    }
    public void deleteContact(Contact contact){
        storage.getContacts().remove(contact);
    }
    public void addFrendhip(Contact contact1, Contact contact2){
        LinkedList<Contact>contacts = storage.getContacts();
        contact1=contacts.get(contacts.indexOf(contact1));
        contact2 = contacts.get(contacts.indexOf(contact2));
        contact1.getFriends().add(contact2);
        contact2.getFriends().add(contact1);
    }
    public void removeFrendship(Contact contact1, Contact contact2){
        LinkedList<Contact> contacts = storage.getContacts();
        contact1 = contacts.get(contacts.indexOf(contact1));
        contact2 = contacts.get(contacts.indexOf(contact2));
        contact1.getFriends().remove(contact2);
        contact2.getFriends().remove(contact1);
    }

    public void addHobby(Contact contact, Hobby hobby){
        LinkedList<Contact> contacts = storage.getContacts();
        contact = contacts.get(contacts.indexOf(contact));
        contact.getHobbies().add(hobby);
    }

    public void addPlace(Contact contact, Place place) {
        LinkedList<Contact> contacts = storage.getContacts();
        contact = contacts.get(contacts.indexOf(contact));
        contact.getPlaces().add(place);
    }

    public Set<Contact>getFriendsList(Contact contact){
        return contact.getFriends();
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
