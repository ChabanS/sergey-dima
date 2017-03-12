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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Sergey
 */
@Entity
@Table(name = "orders", catalog = "food_service")
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orders", nullable = false)
    private Integer id_orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Goods good;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Clients client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Flags flag;

    @Column(name = "order_time")
    private Date order_time;

    @Column(name = "order_time_complit")
    private Date order_time_complit;

    @Column(name = "order_time_change")
    private Date order_time_change;

    public Orders() {
    }

    public Orders(Goods good, Clients client, User user, Flags flag, Date order_time, Date order_time_complit, Date order_time_change) {
        this.good = good;
        this.client = client;
        this.user = user;
        this.flag = flag;
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

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flags getFlag() {
        return flag;
    }

    public void setFlag(Flags flag) {
        this.flag = flag;
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
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id_orders);
        hash = 11 * hash + Objects.hashCode(this.good);
        hash = 11 * hash + Objects.hashCode(this.client);
        hash = 11 * hash + Objects.hashCode(this.user);
        hash = 11 * hash + Objects.hashCode(this.flag);
        hash = 11 * hash + Objects.hashCode(this.order_time);
        hash = 11 * hash + Objects.hashCode(this.order_time_complit);
        hash = 11 * hash + Objects.hashCode(this.order_time_change);
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
        if (!Objects.equals(this.good, other.good)) {
            return false;
        }
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.flag, other.flag)) {
            return false;
        }
        if (!Objects.equals(this.order_time, other.order_time)) {
            return false;
        }
        if (!Objects.equals(this.order_time_complit, other.order_time_complit)) {
            return false;
        }
        return Objects.equals(this.order_time_change, other.order_time_change);
    }

    @Override
    public String toString() {
        return "Orders{" + "id_orders=" + id_orders + ", good=" + good + ", client=" + client + ", user=" + user + ", flag=" + flag + ", order_time=" + order_time + ", order_time_complit=" + order_time_complit + ", order_time_change=" + order_time_change + '}';
    }
}
