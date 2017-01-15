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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sergey
 */
@Entity
@Table(name = "users", catalog = "food_service", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_users"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByIdUsers", query = "SELECT u FROM Users u WHERE u.idUsers = :idUsers"),
    @NamedQuery(name = "Users.findByUserEmail", query = "SELECT u FROM Users u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "Users.findByUserPsw", query = "SELECT u FROM Users u WHERE u.userPsw = :userPsw"),
    @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_users", nullable = false)
    private Integer idUsers;
    @Basic(optional = false)
    @Column(name = "user_email", nullable = false, length = 45)
    private String userEmail;
    @Basic(optional = false)
    @Column(name = "user_psw", nullable = false, length = 45)
    private String userPsw;
    @Basic(optional = false)
    @Column(name = "user_name", nullable = false, length = 45)
    private String userName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Orders> ordersCollection;

    public Users() {
    }

    public Users(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public Users(Integer idUsers, String userEmail, String userPsw, String userName) {
        this.idUsers = idUsers;
        this.userEmail = userEmail;
        this.userPsw = userPsw;
        this.userName = userName;
    }

    public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        hash += (idUsers != null ? idUsers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idUsers == null && other.idUsers != null) || (this.idUsers != null && !this.idUsers.equals(other.idUsers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.entity.Users[ idUsers=" + idUsers + " ]";
    }
    
}
