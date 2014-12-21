package com.skillsup.dao.impl_txt;

import com.skillsup.dao.MessageDao;
import com.skillsup.model.Contact;
import com.skillsup.model.Message;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageDaoImpl implements MessageDao {

    @Autowired
    private Storage storage;

    public void storeMessage(Message message){
        getStorage().getMessages().add(message);
    }
    public List<Message> getConversation(Contact contact1, Contact contact2){
        List<Message> resultMessages = new LinkedList();

        LinkedList<Message>messages = getStorage().getMessages();
        for(Message message:messages){
            if((contact1.equals(message.getFrom())&&contact2.equals(message.getTo()))||
                    (contact2.equals(message.getFrom()) &&(contact1.equals(message.getTo())))){
                resultMessages.add(message);
            }
        }

        return resultMessages;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
