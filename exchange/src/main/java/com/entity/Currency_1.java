/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dmitriygeforce
 */
@Entity
@Table(name = "currency", catalog = "exchange", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Currency_1.findAll", query = "SELECT c FROM Currency_1 c")
    , @NamedQuery(name = "Currency_1.findById", query = "SELECT c FROM Currency_1 c WHERE c.id = :id")
    , @NamedQuery(name = "Currency_1.findByR030", query = "SELECT c FROM Currency_1 c WHERE c.r030 = :r030")
    , @NamedQuery(name = "Currency_1.findByName", query = "SELECT c FROM Currency_1 c WHERE c.name = :name")
    , @NamedQuery(name = "Currency_1.findByRate", query = "SELECT c FROM Currency_1 c WHERE c.rate = :rate")
    , @NamedQuery(name = "Currency_1.findByCc", query = "SELECT c FROM Currency_1 c WHERE c.cc = :cc")
    , @NamedQuery(name = "Currency_1.findByExchangeDate", query = "SELECT c FROM Currency_1 c WHERE c.exchangeDate = :exchangeDate")
    , @NamedQuery(name = "Currency_1.findByCreateDate", query = "SELECT c FROM Currency_1 c WHERE c.createDate = :createDate")})
public class Currency_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "r030", nullable = false)
    private int r030;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate", nullable = false)
    private double rate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cc", nullable = false, length = 45)
    private String cc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exchangeDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date exchangeDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public Currency_1() {
    }

    public Currency_1(Integer id) {
        this.id = id;
    }

    public Currency_1(Integer id, int r030, String name, double rate, String cc, Date exchangeDate, Date createDate) {
        this.id = id;
        this.r030 = r030;
        this.name = name;
        this.rate = rate;
        this.cc = cc;
        this.exchangeDate = exchangeDate;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getR030() {
        return r030;
    }

    public void setR030(int r030) {
        this.r030 = r030;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public Date getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(Date exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currency_1)) {
            return false;
        }
        Currency_1 other = (Currency_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Currency_1[ id=" + id + " ]";
    }
    
}
