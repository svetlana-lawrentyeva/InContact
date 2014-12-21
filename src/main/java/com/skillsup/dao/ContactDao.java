package com.skillsup.dao;

import com.skillsup.model.Contact;
import com.skillsup.model.Hobby;
import com.skillsup.model.Place;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ContactDao {
    void addContact(Contact contact);

    void deleteContact(Contact contact);

    void addFrendhip(Contact contact1, Contact contact2);

    void removeFrendship(Contact contact1, Contact contact2);

    void addHobby(Contact contact, Hobby hobby);

    Set<Contact> getFriendsList(Contact contact);

    void addPlace(Contact contact, Place place);
}
