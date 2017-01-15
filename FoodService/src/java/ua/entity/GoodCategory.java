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
@Table(name = "good_category", catalog = "food_service", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GoodCategory.findAll", query = "SELECT g FROM GoodCategory g"),
    @NamedQuery(name = "GoodCategory.findByIdGoodCategory", query = "SELECT g FROM GoodCategory g WHERE g.idGoodCategory = :idGoodCategory"),
    @NamedQuery(name = "GoodCategory.findByGoodCategoryName", query = "SELECT g FROM GoodCategory g WHERE g.goodCategoryName = :goodCategoryName")})
public class GoodCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_good_category", nullable = false)
    private Integer idGoodCategory;
    @Basic(optional = false)
    @Column(name = "good_category_name", nullable = false, length = 45)
    private String goodCategoryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGoodCategory")
    private Collection<Goods> goodsCollection;

    public GoodCategory() {
    }

    public GoodCategory(Integer idGoodCategory) {
        this.idGoodCategory = idGoodCategory;
    }

    public GoodCategory(Integer idGoodCategory, String goodCategoryName) {
        this.idGoodCategory = idGoodCategory;
        this.goodCategoryName = goodCategoryName;
    }

    public Integer getIdGoodCategory() {
        return idGoodCategory;
    }

    public void setIdGoodCategory(Integer idGoodCategory) {
        this.idGoodCategory = idGoodCategory;
    }

    public String getGoodCategoryName() {
        return goodCategoryName;
    }

    public void setGoodCategoryName(String goodCategoryName) {
        this.goodCategoryName = goodCategoryName;
    }

    @XmlTransient
    public Collection<Goods> getGoodsCollection() {
        return goodsCollection;
    }

    public void setGoodsCollection(Collection<Goods> goodsCollection) {
        this.goodsCollection = goodsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGoodCategory != null ? idGoodCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GoodCategory)) {
            return false;
        }
        GoodCategory other = (GoodCategory) object;
        if ((this.idGoodCategory == null && other.idGoodCategory != null) || (this.idGoodCategory != null && !this.idGoodCategory.equals(other.idGoodCategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.entity.GoodCategory[ idGoodCategory=" + idGoodCategory + " ]";
    }
    
}
