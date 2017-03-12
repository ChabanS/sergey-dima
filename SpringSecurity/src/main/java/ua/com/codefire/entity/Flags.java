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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Sergey
 */
@Entity
@Table(name = "flags", catalog = "food_service")
public class Flags implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flags", nullable = false)
    private Integer id_flags;
    
    @Column(name = "flag_name", nullable = false, length = 45)
    private String flag_name;

    public Flags() {
    }

    public Flags(String flag_name) {
        this.flag_name = flag_name;
    }

    public Integer getId_flags() {
        return id_flags;
    }

    public void setId_flags(Integer id_flags) {
        this.id_flags = id_flags;
    }

    public String getFlag_name() {
        return flag_name;
    }

    public void setFlag_name(String flag_name) {
        this.flag_name = flag_name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id_flags);
        hash = 97 * hash + Objects.hashCode(this.flag_name);
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
        final Flags other = (Flags) obj;
        if (!Objects.equals(this.flag_name, other.flag_name)) {
            return false;
        }
        return Objects.equals(this.id_flags, other.id_flags);
    }

    @Override
    public String toString() {
        return "Flags{" + "id_flags=" + id_flags + ", flag_name=" + flag_name + '}';
    }

}
