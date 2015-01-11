package com.skillsup.dao;

import com.skillsup.model.Contact;
import com.skillsup.model.Place;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 5:20 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PlaceDao {
    void addPlace(Place place);

    List<Contact> getAllContactsForPlace(Place place);
}
