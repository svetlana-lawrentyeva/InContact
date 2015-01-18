package com.skillsup.service;

import com.skillsup.dao.ContactDao;
import com.skillsup.dao.HobbyDao;
import com.skillsup.dao.MessageDao;
import com.skillsup.dao.PlaceDao;
import com.skillsup.model.Contact;
import com.skillsup.model.Message;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/21/14
 * Time: 12:17 AM
 * To change this template use File | Settings | File Templates.
 */
public interface JavaContactService {
    void createContact(String firstName, String lastName, int year, int month, int day);

    void addHobby(String title, String description);

    void addPlace(String title, String description, double longitude, double latitude);

    void addFrendship(Contact contact1, Contact contact2);

    List<Contact> getFriendList(Contact contact);

    List<Message> getConversation(Contact contact1, Contact contact2);

    ContactDao getContactDao();

    void setContactDao(ContactDao contactDao);

    HobbyDao getHobbyDao();

    void setHobbyDao(HobbyDao hobbyDao);

    PlaceDao getPlaceDao();

    void setPlaceDao(PlaceDao placeDao);

    MessageDao getMessageDao();

    void setMessageDao(MessageDao messageDao);

    Contact getContactById(int id);

    void printContact(Contact contact);
}
