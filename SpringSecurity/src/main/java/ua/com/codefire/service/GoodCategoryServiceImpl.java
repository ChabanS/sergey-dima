/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codefire.dao.GoodCategoryDao;
import ua.com.codefire.entity.GoodCategory;

/**
 *
 * @author Sergey
 */
@Service
@Transactional
public class GoodCategoryServiceImpl implements GoodCategoryService{

    @Autowired
    private GoodCategoryDao goodCategoryDao;
    
    @Override
    public void addGoodCategory(GoodCategory goodCategory) {
        goodCategoryDao.addGoodCategory(goodCategory);
    }
    
}
