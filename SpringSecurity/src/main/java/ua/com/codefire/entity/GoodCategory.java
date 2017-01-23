/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Generated;
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
@Table(name = "GoodCategory", catalog = "food_service")
public class GoodCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_good_category", nullable = false)
    private Integer id_good_category;
    
    @Column(name = "good_category_name", nullable = false, length = 45)
    private String good_category_name;

    public GoodCategory() {
    }

    public GoodCategory(Integer id_good_category, String good_category_name) {
        this.id_good_category = id_good_category;
        this.good_category_name = good_category_name;
    }

    public Integer getId_good_category() {
        return id_good_category;
    }

    public void setId_good_category(Integer id_good_category) {
        this.id_good_category = id_good_category;
    }

    public String getGood_category_name() {
        return good_category_name;
    }

    public void setGood_category_name(String good_category_name) {
        this.good_category_name = good_category_name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id_good_category);
        hash = 83 * hash + Objects.hashCode(this.good_category_name);
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
        final GoodCategory other = (GoodCategory) obj;
        if (!Objects.equals(this.good_category_name, other.good_category_name)) {
            return false;
        }
        if (!Objects.equals(this.id_good_category, other.id_good_category)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GoodCategory{" + "id_good_category=" + id_good_category + ", good_category_name=" + good_category_name + '}';
    }

}