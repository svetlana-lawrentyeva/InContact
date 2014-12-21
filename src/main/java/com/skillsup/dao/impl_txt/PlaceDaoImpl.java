package com.skillsup.dao.impl_txt;

import com.skillsup.dao.PlaceDao;
import com.skillsup.model.Contact;
import com.skillsup.model.Place;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlaceDaoImpl implements PlaceDao {

    @Autowired
    private Storage storage;

    public void addPlace(Place place){
        storage.getPlaces().add(place);
    }
    public Set<Contact> getAllContactsForPlace(Place place){
        Set<Contact> resultContacts = new HashSet<Contact>();

        LinkedList<Contact> contacts = getStorage().getContacts();
        for (Contact contact : contacts) {
            Set<Place> places = contact.getPlaces();
            for (Place p : places) {
                if (p.equals(place))
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
