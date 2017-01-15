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
@Table(name = "flags", catalog = "food_service", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flags.findAll", query = "SELECT f FROM Flags f"),
    @NamedQuery(name = "Flags.findByIdFlags", query = "SELECT f FROM Flags f WHERE f.idFlags = :idFlags"),
    @NamedQuery(name = "Flags.findByFlagName", query = "SELECT f FROM Flags f WHERE f.flagName = :flagName")})
public class Flags implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_flags", nullable = false)
    private Integer idFlags;
    @Basic(optional = false)
    @Column(name = "flag_name", nullable = false, length = 45)
    private String flagName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderFlag")
    private Collection<Orders> ordersCollection;

    public Flags() {
    }

    public Flags(Integer idFlags) {
        this.idFlags = idFlags;
    }

    public Flags(Integer idFlags, String flagName) {
        this.idFlags = idFlags;
        this.flagName = flagName;
    }

    public Integer getIdFlags() {
        return idFlags;
    }

    public void setIdFlags(Integer idFlags) {
        this.idFlags = idFlags;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
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
        hash += (idFlags != null ? idFlags.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flags)) {
            return false;
        }
        Flags other = (Flags) object;
        if ((this.idFlags == null && other.idFlags != null) || (this.idFlags != null && !this.idFlags.equals(other.idFlags))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.entity.Flags[ idFlags=" + idFlags + " ]";
    }
    
}
