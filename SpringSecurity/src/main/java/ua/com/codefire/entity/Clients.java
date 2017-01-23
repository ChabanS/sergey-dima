package ua.com.codefire.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Sergey
 */
@Entity
@Table(name = "clients", catalog = "food_service")
public class Clients implements java.io.Serializable {
    
    private Integer id_clients;
    private String client_tel;
    private String client_name;
    private Date client_regdate;
    private String client_info;

    public Clients() {
    }

    public Clients(String client_tel, String client_name, Date client_regdate, String client_info) {
        this.client_tel = client_tel;
        this.client_name = client_name;
        this.client_regdate = client_regdate;
        this.client_info = client_info;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_clients", unique = true, nullable = false)
    public Integer getId_clients() {
        return id_clients;
    }

    public void setId_clients(Integer id_clients) {
        this.id_clients = id_clients;
    }

    @Column(name = "client_tel", nullable = false, length = 45)
    public String getClient_tel() {
        return client_tel;
    }

    public void setClient_tel(String client_tel) {
        this.client_tel = client_tel;
    }

    @Column(name = "client_name", nullable = false, length = 45)
    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    @Column(name = "client_regdate", nullable = false)
    public Date getClient_regdate() {
        return client_regdate;
    }

    public void setClient_regdate(Date client_regdate) {
        this.client_regdate = client_regdate;
    }

    @Column(name = "client_info", nullable = true, length = 140)
    public String getClient_info() {
        return client_info;
    }

    public void setClient_info(String client_info) {
        this.client_info = client_info;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id_clients);
        hash = 97 * hash + Objects.hashCode(this.client_tel);
        hash = 97 * hash + Objects.hashCode(this.client_name);
        hash = 97 * hash + Objects.hashCode(this.client_regdate);
        hash = 97 * hash + Objects.hashCode(this.client_info);
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
        final Clients other = (Clients) obj;
        if (!Objects.equals(this.client_tel, other.client_tel)) {
            return false;
        }
        if (!Objects.equals(this.client_name, other.client_name)) {
            return false;
        }
        if (!Objects.equals(this.client_info, other.client_info)) {
            return false;
        }
        if (!Objects.equals(this.id_clients, other.id_clients)) {
            return false;
        }
        if (!Objects.equals(this.client_regdate, other.client_regdate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clients{" + "id_clients=" + id_clients + ", client_tel=" + client_tel + ", client_name=" + client_name + ", client_regdate=" + client_regdate + ", client_info=" + client_info + '}';
    }
    
    
    
}
