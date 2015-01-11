package com.skillsup.model.impl;

import com.skillsup.model.Contact;
import com.skillsup.model.Hobby;
import com.skillsup.model.Message;
import com.skillsup.model.Place;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="contacts")
public class ContactImpl implements Contact, Serializable{

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name="first_name")
    private String firstName;


    @Column(name="last_name")
    private String lastName;


    @Column(columnDefinition = "DATETIME", name="birth_date")
    private LocalDate birthDate;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = HobbyImpl.class)
    @JoinTable(name="contact_hobby",
            joinColumns = {@JoinColumn(name="id_contact")},
            inverseJoinColumns = {@JoinColumn(name="id_hobby")})
    private Set<Hobby>hobbies;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Place.class)
    @JoinTable(name="contact_place",
            joinColumns = {@JoinColumn(name="id_contact")},
            inverseJoinColumns  = {@JoinColumn(name="id_place")})
    private Set<Place>places;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = ContactImpl.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="friends",
            joinColumns = {@JoinColumn(name="id_contact")},
            inverseJoinColumns = {@JoinColumn(name = "id_friend")})
    private Set<Contact>friends;


    @ManyToMany(mappedBy = "friends", targetEntity = ContactImpl.class)
    private Set<Contact>contacts;

    @OneToMany(targetEntity = MessageImpl.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "messages")
    private Set<Message>messagesFrom;

    @OneToMany(targetEntity = MessageImpl.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "messages")
    private Set<Message>messagesTo;

    //========================================================================

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Contact> getFriends() {
        return friends;
    }

    public void setFriends(Set<Contact> friends) {
        this.friends = friends;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Set<Message> getMessagesFrom() {
        return messagesFrom;
    }

    public void setMessagesFrom(Set<Message> messagesFrom) {
        this.messagesFrom = messagesFrom;
    }

    public Set<Message> getMessagesTo() {
        return messagesTo;
    }

    public void setMessagesTo(Set<Message> messagesTo) {
        this.messagesTo = messagesTo;
    }
}
