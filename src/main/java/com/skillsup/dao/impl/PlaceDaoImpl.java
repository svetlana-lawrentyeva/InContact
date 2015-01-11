package com.skillsup.dao.impl;

import com.skillsup.dao.PlaceDao;
import com.skillsup.model.Contact;
import com.skillsup.model.Place;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */


@Repository
public class PlaceDaoImpl implements PlaceDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional(readOnly = false)
    public void addPlace(Place place) {
        sessionFactory.getCurrentSession().save(place);
    }

    @Transactional(readOnly = true)
    public List<Contact> getAllContactsForPlace(Place place) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Contact contact join contact.places place where place.id = :place_id");
        query.setParameter("place_id", place.getId());
        return query.list();
    }
}
