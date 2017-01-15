/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sergey
 */
@Entity
@Table(name = "clients", catalog = "food_service", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_clients"}),
    @UniqueConstraint(columnNames = {"client_tel"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findByIdClients", query = "SELECT c FROM Clients c WHERE c.idClients = :idClients"),
    @NamedQuery(name = "Clients.findByClientTel", query = "SELECT c FROM Clients c WHERE c.clientTel = :clientTel"),
    @NamedQuery(name = "Clients.findByClientName", query = "SELECT c FROM Clients c WHERE c.clientName = :clientName"),
    @NamedQuery(name = "Clients.findByClientRegdate", query = "SELECT c FROM Clients c WHERE c.clientRegdate = :clientRegdate"),
    @NamedQuery(name = "Clients.findByClientInfo", query = "SELECT c FROM Clients c WHERE c.clientInfo = :clientInfo")})
public class Clients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_clients", nullable = false)
    private Integer idClients;
    @Basic(optional = false)
    @Column(name = "client_tel", nullable = false, length = 45)
    private String clientTel;
    @Basic(optional = false)
    @Column(name = "client_name", nullable = false, length = 45)
    private String clientName;
    @Basic(optional = false)
    @Column(name = "client_regdate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date clientRegdate;
    @Column(name = "client_info", length = 140)
    private String clientInfo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private Collection<ClientAdr> clientAdrCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient")
    private Collection<Orders> ordersCollection;

    public Clients() {
    }

    public Clients(Integer idClients) {
        this.idClients = idClients;
    }

    public Clients(Integer idClients, String clientTel, String clientName, Date clientRegdate) {
        this.idClients = idClients;
        this.clientTel = clientTel;
        this.clientName = clientName;
        this.clientRegdate = clientRegdate;
    }

    public Integer getIdClients() {
        return idClients;
    }

    public void setIdClients(Integer idClients) {
        this.idClients = idClients;
    }

    public String getClientTel() {
        return clientTel;
    }

    public void setClientTel(String clientTel) {
        this.clientTel = clientTel;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getClientRegdate() {
        return clientRegdate;
    }

    public void setClientRegdate(Date clientRegdate) {
        this.clientRegdate = clientRegdate;
    }

    public String getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(String clientInfo) {
        this.clientInfo = clientInfo;
    }

    @XmlTransient
    public Collection<ClientAdr> getClientAdrCollection() {
        return clientAdrCollection;
    }

    public void setClientAdrCollection(Collection<ClientAdr> clientAdrCollection) {
        this.clientAdrCollection = clientAdrCollection;
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
        hash += (idClients != null ? idClients.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.idClients == null && other.idClients != null) || (this.idClients != null && !this.idClients.equals(other.idClients))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.entity.Clients[ idClients=" + idClients + " ]";
    }
    
}
