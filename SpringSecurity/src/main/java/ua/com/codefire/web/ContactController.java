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
import ua.com.codefire.entity.GoodCategory;
import ua.com.codefire.entity.Goods;
import ua.com.codefire.entity.User;
import ua.com.codefire.service.ContactService;
import ua.com.codefire.service.GoodCategoryService;
import ua.com.codefire.service.GoodsService;
import ua.com.codefire.service.UserService;
import ua.com.codefire.util.Validator;

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

    @Autowired
    private Validator validator;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodCategoryService goodCategoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:/login.jsp";
    }

    @RequestMapping("/index")
    public String checkSignIn() {
        return "menu";
    }

//    @RequestMapping("/index")
//    public String listContacts(Map<String, Object> map) {
//        map.put("contact", new Contact());
//        map.put("contactList", contactService.listContact());
//        return "contact";
//    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUser(Map<String, Object> map) {
        map.put("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user) {
        //if (validator.emailValidator(user.getUsername()) && validator.passValidator(user.getPassword())) {
        //if()
        userService.register(user);
        return "menu";
//        }
//        return "register";
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

    @RequestMapping("/test")
    public String test() {
        GoodCategory goodCategory = new GoodCategory("TestDrink");
        goodCategoryService.addGoodCategory(goodCategory);
        goodsService.addGood(new Goods("Beer", 4.9, goodCategory));
        return "menu";
    }
}
