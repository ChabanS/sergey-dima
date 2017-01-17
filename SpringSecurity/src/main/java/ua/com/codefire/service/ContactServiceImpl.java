/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codefire.dao.ContactDAO;
import ua.com.codefire.entity.Contact;

/**
 *
 * @author CodeFire
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Override
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> listContact() {
        return contactDAO.listContact();
    }

    @Override
    public void removeContact(Integer id) {
        contactDAO.removeContact(id);
    }

}
