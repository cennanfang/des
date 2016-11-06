package com.redbird.wehelp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbird.wehelp.dao.PermissionDao;
import com.redbird.wehelp.dao.UserDao;
import com.redbird.wehelp.dao.UserRoleDao;
import com.redbird.wehelp.pojo.ActiveUser;
import com.redbird.wehelp.pojo.Permission;
import com.redbird.wehelp.pojo.Role;
import com.redbird.wehelp.pojo.User;
import com.redbird.wehelp.pojo.UserRole;
import com.redbird.wehelp.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private UserDao userDao;  
	@Autowired
    private UserRoleDao userRoleDao;
	@Autowired
    private PermissionDao permissionDao;  
  
    @Override
    public List<Permission> findPermissionsByUserId(int userId) {  
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
    public ActiveUser loadPermissions(ActiveUser au) {  
        List<Permission> permissions = new ArrayList<Permission>();
        List<Role> roles = new ArrayList<Role>();
        List<UserRole> userRoles = userRoleDao.findByUserId(au.getId());
        for (UserRole userRole : userRoles) {  
            Role role = userRole.getRole(); 
            roles.add(role);
            List<Permission> pms = permissionDao.findPermissionByRoleId(role.getId());  
            permissions.addAll(pms);
        }  
        au.setRoles(roles);
        return au;  
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
