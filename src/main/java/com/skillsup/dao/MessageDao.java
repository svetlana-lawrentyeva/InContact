package com.skillsup.dao;

import com.skillsup.model.Contact;
import com.skillsup.model.Message;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 5:20 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MessageDao {
    void storeMessage(Message message);

    List<Message> getConversation(Contact contact1, Contact contact2);
}
