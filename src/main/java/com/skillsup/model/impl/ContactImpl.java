package com.skillsup.model.impl;

import com.skillsup.model.Contact;
import com.skillsup.model.Hobby;
import com.skillsup.model.Message;
import com.skillsup.model.Place;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
    private Date birthDate;

    @ManyToMany(targetEntity = com.skillsup.model.impl.HobbyImpl.class, fetch = FetchType.EAGER)
    @JoinTable(name="contact_hobby",
            joinColumns =
            @JoinColumn(name="id_contact", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name="id_hobby", referencedColumnName = "id"))
    private Set<Hobby>hobbies;

    @ManyToMany(targetEntity = com.skillsup.model.impl.PlaceImpl.class, fetch = FetchType.EAGER)
    @JoinTable(name="contact_place",
            joinColumns =
            @JoinColumn(name="id_contact", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name="id_place", referencedColumnName = "id"))
    private Set<Place>places;

    @ManyToMany(targetEntity = com.skillsup.model.impl.ContactImpl.class, fetch = FetchType.EAGER)
    @JoinTable(name="friends",
            joinColumns =
            @JoinColumn(name="id_contact", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "id_friend", referencedColumnName = "id"))
    private Set<Contact>friends;

    @ManyToMany(mappedBy = "friends", targetEntity = com.skillsup.model.impl.ContactImpl.class, fetch = FetchType.EAGER)
    private Set<Contact>friendOf;

    @OneToMany(targetEntity = MessageImpl.class, cascade = CascadeType.ALL, mappedBy = "from", fetch = FetchType.EAGER)
    private Set<Message>messagesFrom;

    @OneToMany(targetEntity = MessageImpl.class, cascade = CascadeType.ALL, mappedBy = "to", fetch = FetchType.EAGER)
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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

    public Set<Contact> getFriendOf() {
        return friendOf;
    }

    public void setFriendOf(Set<Contact> friendOf) {
        this.friendOf = friendOf;
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

    public void printContact() {
        System.out.println(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(this.id).append("\n");
        sb.append("first name: ").append(this.firstName).append("\n");
        sb.append("last name: ").append(this.lastName).append("\n");
        sb.append("birthday: ").append(this.birthDate).append("\n");

        return sb.toString();
    }
}
