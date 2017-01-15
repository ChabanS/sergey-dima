/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sergey
 */
@Entity
@Table(name = "client_adr", catalog = "food_service", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientAdr.findAll", query = "SELECT c FROM ClientAdr c"),
    @NamedQuery(name = "ClientAdr.findByIdAdr", query = "SELECT c FROM ClientAdr c WHERE c.idAdr = :idAdr"),
    @NamedQuery(name = "ClientAdr.findByCity", query = "SELECT c FROM ClientAdr c WHERE c.city = :city"),
    @NamedQuery(name = "ClientAdr.findByStreet", query = "SELECT c FROM ClientAdr c WHERE c.street = :street"),
    @NamedQuery(name = "ClientAdr.findByHouse", query = "SELECT c FROM ClientAdr c WHERE c.house = :house"),
    @NamedQuery(name = "ClientAdr.findByApartment", query = "SELECT c FROM ClientAdr c WHERE c.apartment = :apartment"),
    @NamedQuery(name = "ClientAdr.findByFloor", query = "SELECT c FROM ClientAdr c WHERE c.floor = :floor"),
    @NamedQuery(name = "ClientAdr.findByPorch", query = "SELECT c FROM ClientAdr c WHERE c.porch = :porch")})
public class ClientAdr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_adr", nullable = false)
    private Integer idAdr;
    @Basic(optional = false)
    @Column(name = "city", nullable = false, length = 45)
    private String city;
    @Basic(optional = false)
    @Column(name = "street", nullable = false, length = 45)
    private String street;
    @Basic(optional = false)
    @Column(name = "house", nullable = false, length = 45)
    private String house;
    @Column(name = "apartment", length = 45)
    private String apartment;
    @Column(name = "floor")
    private Integer floor;
    @Column(name = "porch")
    private Integer porch;
    @JoinColumn(name = "id_client", referencedColumnName = "id_clients", nullable = false)
    @ManyToOne(optional = false)
    private Clients idClient;

    public ClientAdr() {
    }

    public ClientAdr(Integer idAdr) {
        this.idAdr = idAdr;
    }

    public ClientAdr(Integer idAdr, String city, String street, String house) {
        this.idAdr = idAdr;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public Integer getIdAdr() {
        return idAdr;
    }

    public void setIdAdr(Integer idAdr) {
        this.idAdr = idAdr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getPorch() {
        return porch;
    }

    public void setPorch(Integer porch) {
        this.porch = porch;
    }

    public Clients getIdClient() {
        return idClient;
    }

    public void setIdClient(Clients idClient) {
        this.idClient = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdr != null ? idAdr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientAdr)) {
            return false;
        }
        ClientAdr other = (ClientAdr) object;
        if ((this.idAdr == null && other.idAdr != null) || (this.idAdr != null && !this.idAdr.equals(other.idAdr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.entity.ClientAdr[ idAdr=" + idAdr + " ]";
    }
    
}
