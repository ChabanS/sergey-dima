/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.entity;

import java.io.Serializable;
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
@Table(name = "clientAdr")
public class ClientAdr implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adr", nullable = false, unique = true)
    private Integer id_adr;

    @Column(name = "id_client", nullable = false)
    private Integer id_client;

    @Column(name = "city", nullable = false, length = 45)
    private String city;

    @Column(name = "street", nullable = false, length = 45)
    private String street;

    @Column(name = "house", nullable = false, length = 45)
    private String house;

    @Column(name = "apartment", nullable = true)
    private String apartment;

    @Column(name = "floor", nullable = true)
    private Integer floor;

    @Column(name = "porch", nullable = true)
    private Integer porch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_clients", nullable = false)
    private Clients clients;

    public ClientAdr() {
    }

    public ClientAdr(Integer id_client, String city, String street, String house, String apartment, Integer floor, Integer porch, Clients clients) {
        this.id_client = id_client;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.floor = floor;
        this.porch = porch;
        this.clients = clients;
    }

    public Integer getId_adr() {
        return id_adr;
    }

    public void setId_adr(Integer id_adr) {
        this.id_adr = id_adr;
    }

    public Integer getId_client() {
        return id_client;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
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

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id_adr);
        hash = 61 * hash + Objects.hashCode(this.id_client);
        hash = 61 * hash + Objects.hashCode(this.city);
        hash = 61 * hash + Objects.hashCode(this.street);
        hash = 61 * hash + Objects.hashCode(this.house);
        hash = 61 * hash + Objects.hashCode(this.apartment);
        hash = 61 * hash + Objects.hashCode(this.floor);
        hash = 61 * hash + Objects.hashCode(this.porch);
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
        final ClientAdr other = (ClientAdr) obj;
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.house, other.house)) {
            return false;
        }
        if (!Objects.equals(this.apartment, other.apartment)) {
            return false;
        }
        if (!Objects.equals(this.id_adr, other.id_adr)) {
            return false;
        }
        if (!Objects.equals(this.id_client, other.id_client)) {
            return false;
        }
        if (!Objects.equals(this.floor, other.floor)) {
            return false;
        }
        return Objects.equals(this.porch, other.porch);
    }

    @Override
    public String toString() {
        return "ClientAdr{" + "id_adr=" + id_adr + ", id_client=" + id_client + ", city=" + city + ", street=" + street + ", house=" + house + ", apartment=" + apartment + ", floor=" + floor + ", porch=" + porch + '}';
    }
}
