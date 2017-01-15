/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sergey
 */
@Entity
@Table(name = "goods", catalog = "food_service", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Goods.findAll", query = "SELECT g FROM Goods g"),
    @NamedQuery(name = "Goods.findByIdGoods", query = "SELECT g FROM Goods g WHERE g.idGoods = :idGoods"),
    @NamedQuery(name = "Goods.findByGoodName", query = "SELECT g FROM Goods g WHERE g.goodName = :goodName"),
    @NamedQuery(name = "Goods.findByGoodPrice", query = "SELECT g FROM Goods g WHERE g.goodPrice = :goodPrice")})
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_goods", nullable = false)
    private Integer idGoods;
    @Basic(optional = false)
    @Column(name = "good_name", nullable = false, length = 45)
    private String goodName;
    @Basic(optional = false)
    @Column(name = "good_price", nullable = false)
    private double goodPrice;
    @JoinColumn(name = "id_good_category", referencedColumnName = "id_good_category", nullable = false)
    @ManyToOne(optional = false)
    private GoodCategory idGoodCategory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGoods")
    private Collection<Orders> ordersCollection;

    public Goods() {
    }

    public Goods(Integer idGoods) {
        this.idGoods = idGoods;
    }

    public Goods(Integer idGoods, String goodName, double goodPrice) {
        this.idGoods = idGoods;
        this.goodName = goodName;
        this.goodPrice = goodPrice;
    }

    public Integer getIdGoods() {
        return idGoods;
    }

    public void setIdGoods(Integer idGoods) {
        this.idGoods = idGoods;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public GoodCategory getIdGoodCategory() {
        return idGoodCategory;
    }

    public void setIdGoodCategory(GoodCategory idGoodCategory) {
        this.idGoodCategory = idGoodCategory;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGoods != null ? idGoods.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Goods)) {
            return false;
        }
        Goods other = (Goods) object;
        if ((this.idGoods == null && other.idGoods != null) || (this.idGoods != null && !this.idGoods.equals(other.idGoods))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.entity.Goods[ idGoods=" + idGoods + " ]";
    }
    
}
