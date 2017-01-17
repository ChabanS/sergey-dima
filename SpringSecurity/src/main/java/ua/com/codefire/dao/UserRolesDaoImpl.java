/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.dao;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.codefire.entity.UserRoles;

/**
 *
 * @author CodeFire
 */
@Repository
public class UserRolesDaoImpl implements UserRolesDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Set<UserRoles> getAll() {
        return new HashSet<>(sessionFactory.getCurrentSession().createQuery("from UserRoles").list());
    }

    @Override
    public void save(UserRoles role) {
        sessionFactory.getCurrentSession().save(role);
    }

}
