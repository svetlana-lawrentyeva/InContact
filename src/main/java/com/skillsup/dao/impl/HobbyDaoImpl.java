package com.skillsup.dao.impl;

import com.skillsup.dao.HobbyDao;
import com.skillsup.model.Contact;
import com.skillsup.model.Hobby;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */


@Repository
public class HobbyDaoImpl implements HobbyDao {

    @Autowired
    private
    SessionFactory sessionFactory;

    @Transactional(readOnly = false)
    public void addHobby(Hobby hobby) {
        sessionFactory.getCurrentSession().save(hobby);
    }

    @Transactional(readOnly = true)
    public List<Contact> getAllContactsWithHobby(Hobby hobby) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Contact contact join contact.hobbies hobby where hobby.id = :hobby_id");
        query.setParameter("hobby_id", hobby.getId());
        return query.list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
