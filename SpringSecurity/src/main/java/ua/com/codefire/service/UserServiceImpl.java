/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codefire.dao.UserDao;
import ua.com.codefire.dao.UserRolesDao;
import ua.com.codefire.entity.User;
import ua.com.codefire.entity.UserRoles;

/**
 *
 * @author CodeFire
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private UserRolesDao rolesDao;
    
    @Autowired(required = false)
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public void register(User user) {
        user.setEnabled((byte)1);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //user.setUserRoles(rolesDao.getAll());
        userDao.add(user);
//        rolesDao.save(new UserRoles(user, "ROLE_USER"));
    }

}
