/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.web;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.codefire.entity.Contact;
import ua.com.codefire.entity.User;
import ua.com.codefire.service.ContactService;
import ua.com.codefire.service.UserService;

/**
 *
 * @author CodeFire
 */
@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;
    
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {
        map.put("contact", new Contact());
        map.put("contactList", contactService.listContact());
        return "contact";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUser(Map<String, Object> map) {
        map.put("user", new User());
        return "register";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user){
        userService.register(user);
        return "redirect:/login.jsp";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {
        contactService.addContact(contact);
        return "redirect:/index";
    }

    @RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId") Integer contactId) {
        contactService.removeContact(contactId);
        return "redirect:/index";
    }
}