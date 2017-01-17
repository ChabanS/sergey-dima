/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.dao;

import java.util.Set;
import ua.com.codefire.entity.UserRoles;

/**
 *
 * @author CodeFire
 */
public interface UserRolesDao {
    Set<UserRoles> getAll();
    void save(UserRoles role);
}
