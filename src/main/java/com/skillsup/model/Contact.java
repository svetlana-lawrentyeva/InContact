package com.skillsup.model;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Contact {
    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    LocalDate getBirthDate();

    void setBirthDate(LocalDate birthDate);

    Set<Hobby> getHobbies();

    void setHobbies(Set<Hobby> hobbies);

    Set<Place> getPlaces();

    void setPlaces(Set<Place> places);

    public int getId();

    public void setId(int id);

    public Set<Contact> getFriends();

    public void setFriends(Set<Contact> friends);

    public Set<Contact> getFriendOf();

    public void setFriendOf(Set<Contact> friendOf);

    public Set<Message> getMessagesTo() ;

    public void setMessagesTo(Set<Message> messagesTo);
}
