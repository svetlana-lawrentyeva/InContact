package com.skillsup.dao.impl;

import com.skillsup.dao.MessageDao;
import com.skillsup.model.Contact;
import com.skillsup.model.Message;
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
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 */


@Repository
public class MessageDaoImpl implements MessageDao {

    @Autowired
    private
    SessionFactory sessionFactory;

    @Transactional(readOnly = false)
    public void storeMessage(Message message) {
        sessionFactory.getCurrentSession().save(message);
    }

    @Transactional(readOnly = true)
    public List<Message> getConversation(Contact contact1, Contact contact2) {
        Query query = sessionFactory.getCurrentSession().createQuery("from MessageImpl message join message.to contact_to join message.from contact_from where contact_to.id = :contact_to_id and contact_from.id = :contact_from_id");
        query.setParameter("contact_from_id", contact1.getId());
        query.setParameter("contact_to_id", contact2.getId());
        return query.list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
