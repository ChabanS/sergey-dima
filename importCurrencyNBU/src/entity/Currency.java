/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sergey
 */
@Entity
@Table(name = "currency", catalog = "exchange", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c"),
    @NamedQuery(name = "Currency.findById", query = "SELECT c FROM Currency c WHERE c.id = :id"),
    @NamedQuery(name = "Currency.findByR030", query = "SELECT c FROM Currency c WHERE c.r030 = :r030"),
    @NamedQuery(name = "Currency.findByName", query = "SELECT c FROM Currency c WHERE c.name = :name"),
    @NamedQuery(name = "Currency.findByRate", query = "SELECT c FROM Currency c WHERE c.rate = :rate"),
    @NamedQuery(name = "Currency.findByCc", query = "SELECT c FROM Currency c WHERE c.cc = :cc"),
    @NamedQuery(name = "Currency.findByExchangeDate", query = "SELECT c FROM Currency c WHERE c.exchangeDate = :exchangeDate"),
    @NamedQuery(name = "Currency.findByCreateDate", query = "SELECT c FROM Currency c WHERE c.createDate = :createDate")})
public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "r030", nullable = false)
    private int r030;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Basic(optional = false)
    @Column(name = "rate", nullable = false)
    private double rate;
    @Basic(optional = false)
    @Column(name = "cc", nullable = false, length = 45)
    private String cc;
    @Basic(optional = false)
    @Column(name = "exchangeDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date exchangeDate;
    @Basic(optional = false)
    @Column(name = "createDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public Currency() {
    }

    public Currency(Integer id) {
        this.id = id;
    }

    public Currency(int r030, String name, double rate, String cc, Date exchangeDate, Date createDate) {
        this.r030 = r030;
        this.name = name;
        this.rate = rate;
        this.cc = cc;
        this.exchangeDate = exchangeDate;
        this.createDate = createDate;
    }
    

    public Currency(Integer id, int r030, String name, double rate, String cc, Date exchangeDate, Date createDate) {
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
        if (!(object instanceof Currency)) {
            return false;
        }
        Currency other = (Currency) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Currency[ id=" + id + " ]";
    }
    
}
