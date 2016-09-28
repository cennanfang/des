package com.redbird.wehelp.util;

import com.redbird.wehelp.pojo.ActiveUser;
import com.redbird.wehelp.pojo.User;

/**
 * User����
 * @author c
 *
 */
public class UserUtils {

	/**
	 * ��UserתΪActiveUser
	 * @param user
	 * @return
	 */
	synchronized
	public static ActiveUser userCopyToActiveUser(User user) {
		ActiveUser activeUser = new ActiveUser();
		activeUser.setId(user.getId());
		activeUser.setUserName(user.getUserName());
		activeUser.setNickName(user.getNickName());
		activeUser.setAge(user.getAge());
		activeUser.setSex(user.getSex());
		activeUser.setPhone(user.getPhone());
		activeUser.setEmail(user.getEmail());
		activeUser.setAddress(user.getAddress());
		activeUser.setRegisterDate(user.getRegisterDate());
		return activeUser;
	}
}
