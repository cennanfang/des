package com.redbird.wehelp.security.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.apache.shiro.crypto.hash.Md5Hash;

import com.redbird.wehelp.utils.DataUtils;

public class PasswdUtils {

	/**
	 * 密码对比
	 * @param inputPasswd
	 * @param storePasswd
	 * @param salt
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	synchronized public static boolean checkPassword(String inputPasswd, String storePasswd, String salt) throws UnsupportedEncodingException {
		boolean ok = false;
		System.out.println("checkPassword: inputPasswd=" + inputPasswd + " | storePasswd=" + storePasswd + " | salt=" + salt);
		String inPwd = encryptPasswd(inputPasswd, salt);
		ok = inPwd.equals(storePasswd);
		System.out.println("is matchs = " + ok);
		return ok;
	}

	/**
	 * 密码加密
	 * @param inputPasswd
	 * @param salt
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	synchronized public static String encryptPasswd(String inputPasswd, String salt)
			throws UnsupportedEncodingException {
		String md5Passwd = new Md5Hash(inputPasswd, salt).toString();
		return md5Passwd;
	}

	/**
	 * 生成盐指定长度
	 * @param len
	 * @return
	 */
	synchronized public static String generateSalt(int len) {
		byte[] salt = new byte[len];
		Random rand = new Random();
		for (int i = 0; i < len; i++) {
			salt[i] = (byte) ((rand.nextInt('~' - '!') + '!') & 0x007f);
		}
		return DataUtils.byteArrayToString(salt); 
	}
}