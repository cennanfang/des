package com.redbird.wehelp.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbird.wehelp.dao.PermissionDao;
import com.redbird.wehelp.dao.RoleDao;
import com.redbird.wehelp.dao.UserDao;
import com.redbird.wehelp.dao.UserRoleDao;
import com.redbird.wehelp.pojo.Permission;
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
	private RoleDao roleDao;
	@Autowired
	private PermissionDao permissionDao;
  
    @Override
	public User findByUserName(String userName) {
		return  userDao.findByUserName(userName);
	}  
    
	@Override
	public Set<String> userRoleNames(int userId) {
		List<UserRole> userRoles = userRoleDao.findByUserId(userId);
		if(userRoles != null) {
			Set<String> roleNames = new HashSet<String>();
			for (UserRole userRole : userRoles) {
				int roleId = userRole.getRoleId();
				String roleName = roleDao.find(roleId).getName();
				roleNames.add(roleName);
			}
			return roleNames;
		}
		return null;
	}

	@Override
	public Set<String> userPermissionUrls(int userId) {
		List<UserRole> userRoles = userRoleDao.findByUserId(userId);
		if(userRoles != null) {
			Set<String> permissionUrls = new HashSet<String>();
			for (UserRole userRole : userRoles) {
				int roleId = userRole.getRoleId();
				List<Permission> permissions = permissionDao.findPermissionByRoleId(roleId);
				for (Permission permission : permissions) {
					permissionUrls.add(permission.getUrl());
				}
			}
			return permissionUrls;
		}
		return null;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserRoleDao getUserRoleDao() {
		return userRoleDao;
	}

	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public PermissionDao getPermissionDao() {
		return permissionDao;
	}

	public void setPermissionDao(PermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}

}
