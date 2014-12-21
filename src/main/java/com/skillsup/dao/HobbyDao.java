package com.skillsup.dao;

import com.skillsup.model.Contact;
import com.skillsup.model.Hobby;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
public interface HobbyDao {
    void addHobby(Hobby hobby);

    Set<Contact> getAllContactsWithHobby(Hobby hobby);
}
