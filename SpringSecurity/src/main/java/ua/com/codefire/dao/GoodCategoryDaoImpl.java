/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.codefire.entity.GoodCategory;

/**
 *
 * @author Sergey
 */
@Repository
public class GoodCategoryDaoImpl implements GoodCategoryDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void addGoodCategory(GoodCategory goodCategory) {
        sessionFactory.getCurrentSession().save(goodCategory);
    }
    
}
