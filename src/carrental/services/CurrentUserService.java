/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrental.services;

/**
 *
 * @author ariffazmi
 */
public class CurrentUserService {

    public static String name;
    public static Integer userId;
    
    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        CurrentUserService.name = name;
    }

    public static Integer getUserId() {
        return userId;
    }

    public static void setUserId(Integer userId) {
        CurrentUserService.userId = userId;
    }

}
