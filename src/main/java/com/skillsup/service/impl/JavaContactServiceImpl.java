package com.skillsup.service.impl;

import com.skillsup.dao.ContactDao;
import com.skillsup.dao.HobbyDao;
import com.skillsup.dao.MessageDao;
import com.skillsup.dao.PlaceDao;
import com.skillsup.model.Contact;
import com.skillsup.model.Hobby;
import com.skillsup.model.Message;
import com.skillsup.model.Place;
import com.skillsup.model.impl.ContactImpl;
import com.skillsup.model.impl.HobbyImpl;
import com.skillsup.model.impl.PlaceImpl;
import com.skillsup.service.JavaContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 5:16 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class JavaContactServiceImpl implements JavaContactService {
    @Autowired
    private ContactDao contactDao;
    @Autowired
    private HobbyDao hobbyDao;
    @Autowired
    private PlaceDao placeDao;
    @Autowired
    private MessageDao messageDao;

//    private static int idContactCounter=0;
//    private  static int idHobbyCounter=0;
//    private static int idPlaceCounter=0;

    public void createContact(String firstName, String lastName, int year, int month, int day){

        Contact contact = new ContactImpl();
//        contact.setId(idContactCounter++);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        contact.setBirthDate(c.getTime());
        contactDao.addContact(contact);
    }

    public void addHobby(String title, String description){

        Hobby hobby = new HobbyImpl();
//        hobby.setId(idHobbyCounter++);
        hobby.setTitle(title);
        hobby.setDescription(description);
        hobbyDao.addHobby(hobby);
    }

    public void addPlace(String title, String description, double longitude, double latitude){

        Place place = new PlaceImpl();
//        place.setId(idPlaceCounter++);
        place.setTitle(title);
        place.setDescription(description);
        place.setLongitude(longitude);
        place.setLatitude(latitude);
    }

    public void addFrendship(Contact contact1, Contact contact2){
        contactDao.addFrendhip(contact1,contact2);
    }

    public List<Contact> getFriendList(Contact contact){
       return contactDao.getFriendsList(contact);
    }

    public List<Message> getConversation(Contact contact1, Contact contact2){
        return messageDao.getConversation(contact1, contact2);
    }

    public ContactDao getContactDao() {
        return contactDao;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public HobbyDao getHobbyDao() {
        return hobbyDao;
    }

    public void setHobbyDao(HobbyDao hobbyDao) {
        this.hobbyDao = hobbyDao;
    }

    public PlaceDao getPlaceDao() {
        return placeDao;
    }

    public void setPlaceDao(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public Contact getContactById(int id) {
        return this.contactDao.getContactById(id);
    }

    public void printContact(Contact contact) {
        contact.printContact();
    }


}
