package com.redbird.wehelp.service;

import java.util.ArrayList;
import java.util.List;

import com.redbird.wehelp.dao.UserDao;
import com.redbird.wehelp.pojo.User;

public class AccountService {

    private UserDao userDao;  
	/**** 
     * 通过用户名获取用户对象 
     *  
     * @param username 
     * @return 
     */  
    public User getUserByUserName(String userName) {  
        User user =  userDao.findByUserName(userName);  
        return user;  
    }  
  
    /*** 
     * 通过用户名获取权限资源 
     *  
     * @param username 
     * @return 
     */  
    public List<String> getPermissionsByUserName(String username) {  
        System.out.println("调用");  
        User user = getUserByUserName(username);  
        if (user == null) {  
            return null;  
        }  
        List<String> list = new ArrayList<String>();  
//        // System.out.println(user.getUserRoles().get(0).get);  
//        for (UserRole userRole : user.getUserRoles()) {  
//            Role role = userRole.getRole();  
//            List<Permission> permissions = userDao.findAllByHQL("FROM Permission WHERE roleId = ?", new Object[] { role.getId() });  
//            for (Permission p : permissions) {  
//                list.add(p.getUrl());  
//            }  
//        }  
        return list;  
    }  
  
}
