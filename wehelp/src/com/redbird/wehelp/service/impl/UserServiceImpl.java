package com.redbird.wehelp.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.redbird.wehelp.dao.PermissionDao;
import com.redbird.wehelp.dao.UserDao;
import com.redbird.wehelp.dao.UserRoleDao;
import com.redbird.wehelp.pojo.Permission;
import com.redbird.wehelp.pojo.Role;
import com.redbird.wehelp.pojo.User;
import com.redbird.wehelp.pojo.UserRole;
import com.redbird.wehelp.service.UserService;

public class UserServiceImpl implements UserService{

    private UserDao userDao;  
    private UserRoleDao userRoleDao;
    private PermissionDao permissionDao;  
  
    /*** 
     * 通过用户ID获取权限资源 
     *  
     * @param username 
     * @return 
     */  
    @Override
    public List<Permission> findPermissionsByUserId(int userId) {  
        System.out.println("调用");  
        User user = userDao.find(userId);  
        if (user == null) {  
            return null;  
        }  
        List<Permission> meus = new ArrayList<Permission>();
        List<UserRole> userRoles = userRoleDao.findByUserId(userId);
        for (UserRole userRole : userRoles) {  
            Role role = userRole.getRole();  
            List<Permission> permissions = permissionDao.findPermissionByRoleId(role.getId());  
            for (Permission p : permissions) {  
            	meus.add(p);  
            }  
        }  
        return meus;  
    }
    
    @Override
	public User findByUserName(String userName) {
    	User user = userDao.findByUserName(userName);
		return user;
	}  

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public PermissionDao getPermissionDao() {
		return permissionDao;
	}

	public void setPermissionDao(PermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}

	public UserRoleDao getUserRoleDao() {
		return userRoleDao;
	}

	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

}
