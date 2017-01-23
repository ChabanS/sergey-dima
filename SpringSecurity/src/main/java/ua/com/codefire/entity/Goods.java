/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Sergey
 */
@Entity
@Table(name = "goods", catalog = "food_service")
public class Goods implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_goods", nullable = false)
    private Integer id_goods;
    
    @Column(name = "id_goods_category", nullable = false)
    private Integer id_goods_category;
    
    @Column(name = "good_name", nullable = false, length = 45)
    private String good_name;
    
    @Column(name = "good_price", nullable = false)
    private Double good_price;

    public Goods() {
    }
    
    public Goods(Integer id_goods_category, String good_name, Double good_price) {
        this.id_goods_category = id_goods_category;
        this.good_name = good_name;
        this.good_price = good_price;
    }

    public Integer getId_goods() {
        return id_goods;
    }

    public void setId_goods(Integer id_goods) {
        this.id_goods = id_goods;
    }

    public Integer getId_goods_category() {
        return id_goods_category;
    }

    public void setId_goods_category(Integer id_goods_category) {
        this.id_goods_category = id_goods_category;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public Double getGood_price() {
        return good_price;
    }

    public void setGood_price(Double good_price) {
        this.good_price = good_price;
    }

    
    
}
