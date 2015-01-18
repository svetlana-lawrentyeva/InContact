package com.skillsup;

import com.skillsup.model.Contact;
import com.skillsup.service.JavaContactService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: nau
 * Date: 12/20/14
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        JavaContactService javaContactService = (JavaContactService) ctx.getBean("javaContactService");
        javaContactService.createContact("nikolay", "nikolayev", 1980, 8, 5);
        javaContactService.createContact("ivan", "ivanov", 1975, 12, 1);
        javaContactService.addHobby("computer", "programming");
        Contact contact1 = javaContactService.getContactById(1);
        Contact contact2 = javaContactService.getContactById(2);
        javaContactService.addFrendship(contact1, contact2);
        javaContactService.printContact(contact1);
        javaContactService.printContact(contact2);




//        ContactDao contactDao = new ContactDaoImpl();
//        Contact contact = new ContactImpl();
//        contact.setId(0);
//        contact.setFirstName("qwe");
//        contact.setLastName("rty");
//        contactDao.addContact(contact);
////        contactDao.deleteContact(contact);
//        Contact contact1 = new ContactImpl();
//        contact1.setId(1);
//        contact1.setFirstName("asd");
//        contact1.setLastName("fgh");
//        contactDao.addContact(contact1);
//
//
//        Contact contact2 = new ContactImpl();
//        contact2.setId(2);
//        contact2.setFirstName("qwe");
//        contact2.setLastName("rty");
//        contactDao.addContact(contact2);
//
//
//        Contact contact3 = new ContactImpl();
//        contact3.setId(3);
//        contact3.setFirstName("qwe");
//        contact3.setLastName("rty");
//        contactDao.addContact(contact3);
//
//        contactDao.addFrendhip(contact, contact1);
//        contactDao.addFrendhip(contact, contact2);
//        contactDao.addFrendhip(contact, contact3);
//        contactDao.removeFrendship(contact,contact1);
//
//        Hobby hobby = new HobbyImpl();
//        hobby.setId(0);
//        hobby.setTitle("smoking");
//        HobbyDao hobbyDao = new HobbyDaoImpl();
//        hobbyDao.addHobby(hobby);
//
//        Hobby hobby1 = new HobbyImpl();
//        hobby1.setId(1);
//        hobby1.setTitle("dancing");
//        hobbyDao.addHobby(hobby1);
//
//        contact.getHobbies().add(hobby);
//        contact.getHobbies().add(hobby1);
//        contact1.getHobbies().add(hobby1);
//        contact2.getHobbies().add(hobby1);
//        contact3.getHobbies().add(hobby);
//
//

    }

}
