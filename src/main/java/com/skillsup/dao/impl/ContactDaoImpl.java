package com.skillsup.dao.impl;

import com.skillsup.dao.ContactDao;
import com.skillsup.model.Contact;
import com.skillsup.model.Hobby;
import com.skillsup.model.Place;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class ContactDaoImpl implements ContactDao {

    @Autowired
    private
    SessionFactory sessionFactory;

    @Transactional(readOnly = false)
    public void addContact(Contact contact) {
        getSessionFactory().getCurrentSession().save(contact);
    }

    public void deleteContact(Contact contact) {
        getSessionFactory().getCurrentSession().delete(contact);
    }

    @Transactional(readOnly = false)
    public void addFrendhip(Contact contact1, Contact contact2) {
        contact1.getFriends().add(contact2);
        contact1.getFriendOf().add(contact2);
        contact2.getFriends().add(contact1);
        contact2.getFriendOf().add(contact1);
        getSessionFactory().getCurrentSession().update(contact1);
        getSessionFactory().getCurrentSession().update(contact2);
    }

    public void removeFrendship(Contact contact1, Contact contact2) {
        contact1.getFriends().remove(contact2);
        contact1.getFriendOf().remove(contact2);
        contact2.getFriends().remove(contact1);
        contact2.getFriendOf().remove(contact1);
        getSessionFactory().getCurrentSession().update(contact1);
        getSessionFactory().getCurrentSession().update(contact2);
    }

    @Transactional(readOnly = false)
    public void addHobby(Contact contact, Hobby hobby) {
        contact.getHobbies().add(hobby);
        getSessionFactory().getCurrentSession().update(contact);
    }

    @Transactional(readOnly = true)
    public List<Contact> getFriendsList(Contact contact) {
        Query query = getSessionFactory().getCurrentSession().createQuery("from ContactImpl contact join contact.friends friends where contact.id = :contact_id");
        query.setParameter("contact_id", contact.getId());
        return query.list();
    }

    @Transactional(readOnly = false)
    public void addPlace(Contact contact, Place place) {
        contact.getPlaces().add(place);
        getSessionFactory().getCurrentSession().update(contact);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public Contact getContactById(int id) {
        Query query = getSessionFactory().getCurrentSession().createQuery("from ContactImpl contact where id = :id");
        query.setParameter("id", id);
        return (Contact) query.uniqueResult();
    }
}
