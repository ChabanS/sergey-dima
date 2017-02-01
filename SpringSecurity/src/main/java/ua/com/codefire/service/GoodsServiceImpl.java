/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codefire.dao.GoodsDao;
import ua.com.codefire.entity.Goods;

/**
 *
 * @author Sergey
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    GoodsDao goods;
    
    @Override
    public void addGood(Goods good) {
        goods.addGood(good);
    }
    
}
