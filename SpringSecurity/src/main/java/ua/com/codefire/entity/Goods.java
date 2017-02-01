/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sergey
 */
@Entity
@Table(name = "goods", catalog = "food_service")
public class Goods implements Serializable {
    
    private Integer id_goods;
    private String good_name;
    private Double good_price;
    private GoodCategory goodCategory;

    public Goods() {
    }

    public Goods(String good_name, Double good_price, GoodCategory goodCategory) {
        this.good_name = good_name;
        this.good_price = good_price;
        this.goodCategory = goodCategory;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_goods", nullable = false)
    public Integer getId_goods() {
        return id_goods;
    }

    public void setId_goods(Integer id_goods) {
        this.id_goods = id_goods;
    }

    @Column(name = "good_name", nullable = false, length = 45)
    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    @Column(name = "good_price", nullable = false)
    public Double getGood_price() {
        return good_price;
    }

    public void setGood_price(Double good_price) {
        this.good_price = good_price;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_good_category", nullable = false)
    public GoodCategory getGoodCategory() {
        return goodCategory;
    }

    public void setGoodCategory(GoodCategory goodCategory) {
        this.goodCategory = goodCategory;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id_goods);
        hash = 89 * hash + Objects.hashCode(this.good_name);
        hash = 89 * hash + Objects.hashCode(this.good_price);
        hash = 89 * hash + Objects.hashCode(this.goodCategory);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Goods other = (Goods) obj;
        if (!Objects.equals(this.good_name, other.good_name)) {
            return false;
        }
        if (!Objects.equals(this.id_goods, other.id_goods)) {
            return false;
        }
        if (!Objects.equals(this.good_price, other.good_price)) {
            return false;
        }
        if (!Objects.equals(this.goodCategory, other.goodCategory)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Goods{" + "id_goods=" + id_goods + ", good_name=" + good_name + ", good_price=" + good_price + ", goodCategory=" + goodCategory + '}';
    }
}
