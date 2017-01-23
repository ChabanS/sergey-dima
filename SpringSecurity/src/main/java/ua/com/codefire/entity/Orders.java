/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
@Table(name = "orders", catalog = "food_service")
public class Orders implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orders", nullable = false)
    private Integer id_orders;
    
    @Column(name = "id_goods", nullable = false)
    private Integer id_goods;
    
    @Column(name = "id_client", nullable = false)
    private Integer id_client;
    
    @Column(name = "id_user", nullable = false)
    private Integer id_user;
    
    @Column(name = "order_flag", nullable = false)
    private Integer order_flag;
    
    @Column(name = "order_time")
    private Date order_time;
    
    @Column(name = "order_time_complit")
    private Date order_time_complit;
    
    @Column(name = "order_time_change")
    private Date order_time_change;
    
     public Orders() {
    }

    public Orders(Integer id_goods, Integer id_client, Integer id_user, Integer order_flag, Date order_time, Date order_time_complit, Date order_time_change) {
        this.id_goods = id_goods;
        this.id_client = id_client;
        this.id_user = id_user;
        this.order_flag = order_flag;
        this.order_time = order_time;
        this.order_time_complit = order_time_complit;
        this.order_time_change = order_time_change;
    }

    public Integer getId_orders() {
        return id_orders;
    }

    public void setId_orders(Integer id_orders) {
        this.id_orders = id_orders;
    }

    public Integer getId_goods() {
        return id_goods;
    }

    public void setId_goods(Integer id_goods) {
        this.id_goods = id_goods;
    }

    public Integer getId_client() {
        return id_client;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getOrder_flag() {
        return order_flag;
    }

    public void setOrder_flag(Integer order_flag) {
        this.order_flag = order_flag;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public Date getOrder_time_complit() {
        return order_time_complit;
    }

    public void setOrder_time_complit(Date order_time_complit) {
        this.order_time_complit = order_time_complit;
    }

    public Date getOrder_time_change() {
        return order_time_change;
    }

    public void setOrder_time_change(Date order_time_change) {
        this.order_time_change = order_time_change;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id_orders);
        hash = 59 * hash + Objects.hashCode(this.id_goods);
        hash = 59 * hash + Objects.hashCode(this.id_client);
        hash = 59 * hash + Objects.hashCode(this.id_user);
        hash = 59 * hash + Objects.hashCode(this.order_flag);
        hash = 59 * hash + Objects.hashCode(this.order_time);
        hash = 59 * hash + Objects.hashCode(this.order_time_complit);
        hash = 59 * hash + Objects.hashCode(this.order_time_change);
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
        final Orders other = (Orders) obj;
        if (!Objects.equals(this.id_orders, other.id_orders)) {
            return false;
        }
        if (!Objects.equals(this.id_goods, other.id_goods)) {
            return false;
        }
        if (!Objects.equals(this.id_client, other.id_client)) {
            return false;
        }
        if (!Objects.equals(this.id_user, other.id_user)) {
            return false;
        }
        if (!Objects.equals(this.order_flag, other.order_flag)) {
            return false;
        }
        if (!Objects.equals(this.order_time, other.order_time)) {
            return false;
        }
        if (!Objects.equals(this.order_time_complit, other.order_time_complit)) {
            return false;
        }
        if (!Objects.equals(this.order_time_change, other.order_time_change)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Orders{" + "id_orders=" + id_orders + ", id_goods=" + id_goods + ", id_client=" + id_client + ", id_user=" + id_user + ", order_flag=" + order_flag + ", order_time=" + order_time + ", order_time_complit=" + order_time_complit + ", order_time_change=" + order_time_change + '}';
    }
     
     
}
