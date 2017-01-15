/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sergey
 */
@Entity
@Table(name = "orders", catalog = "food_service", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByIdOrders", query = "SELECT o FROM Orders o WHERE o.idOrders = :idOrders"),
    @NamedQuery(name = "Orders.findByOrderTime", query = "SELECT o FROM Orders o WHERE o.orderTime = :orderTime"),
    @NamedQuery(name = "Orders.findByOrderTimeComplit", query = "SELECT o FROM Orders o WHERE o.orderTimeComplit = :orderTimeComplit"),
    @NamedQuery(name = "Orders.findByOrderTimeChange", query = "SELECT o FROM Orders o WHERE o.orderTimeChange = :orderTimeChange")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orders", nullable = false)
    private Integer idOrders;
    @Basic(optional = false)
    @Column(name = "order_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTime;
    @Basic(optional = false)
    @Column(name = "order_time_complit", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTimeComplit;
    @Column(name = "order_time_change")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTimeChange;
    @JoinColumn(name = "id_client", referencedColumnName = "id_clients", nullable = false)
    @ManyToOne(optional = false)
    private Clients idClient;
    @JoinColumn(name = "order_flag", referencedColumnName = "id_flags", nullable = false)
    @ManyToOne(optional = false)
    private Flags orderFlag;
    @JoinColumn(name = "id_goods", referencedColumnName = "id_goods", nullable = false)
    @ManyToOne(optional = false)
    private Goods idGoods;
    @JoinColumn(name = "id_user", referencedColumnName = "id_users", nullable = false)
    @ManyToOne(optional = false)
    private Users idUser;

    public Orders() {
    }

    public Orders(Integer idOrders) {
        this.idOrders = idOrders;
    }

    public Orders(Integer idOrders, Date orderTime, Date orderTimeComplit) {
        this.idOrders = idOrders;
        this.orderTime = orderTime;
        this.orderTimeComplit = orderTimeComplit;
    }

    public Integer getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(Integer idOrders) {
        this.idOrders = idOrders;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getOrderTimeComplit() {
        return orderTimeComplit;
    }

    public void setOrderTimeComplit(Date orderTimeComplit) {
        this.orderTimeComplit = orderTimeComplit;
    }

    public Date getOrderTimeChange() {
        return orderTimeChange;
    }

    public void setOrderTimeChange(Date orderTimeChange) {
        this.orderTimeChange = orderTimeChange;
    }

    public Clients getIdClient() {
        return idClient;
    }

    public void setIdClient(Clients idClient) {
        this.idClient = idClient;
    }

    public Flags getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(Flags orderFlag) {
        this.orderFlag = orderFlag;
    }

    public Goods getIdGoods() {
        return idGoods;
    }

    public void setIdGoods(Goods idGoods) {
        this.idGoods = idGoods;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrders != null ? idOrders.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.idOrders == null && other.idOrders != null) || (this.idOrders != null && !this.idOrders.equals(other.idOrders))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.entity.Orders[ idOrders=" + idOrders + " ]";
    }
    
}
