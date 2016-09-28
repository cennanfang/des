package com.redbird.wehelp.util;

/**
 * 
 * gensalt=[B@6d06d69c
gensalt2=[B@7852e922
gensalt3=[B@4e25154f
gensalt4=[B@70dea4e
salt to pwd = 483795953644107118
salt to pwd = 99624111433583888
salt to pwd = 464612057111437064
salt to pwd = 6359703777827177
加密后：483795953644107118hSWGVeDaY3DR3tqOmc0CjA==
加密后：99624111433583888GA5w/JyJ+czpf9Ka1pe13g==
加密后：464612057111437064qnLNXxHoB3Fs76NqSZTdoA==
加密后：6359703777827177Pz6aP2/Xz+KNpLyS8Z2yAg==
salt to pwd = 483795953644107118
salt to pwd = 99624111433583888
salt to pwd = 464612057111437064
salt to pwd = 6359703777827177
isOk=true
isOk2=true
isOk3=true
isOk4=true
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Random;

import sun.misc.BASE64Encoder;

/**
 * 对帐号口令前加密
 * 
 * @author c
 *
 */
public class PasswordEncryption {
	private static final MessageDigest md;
	private static final BASE64Encoder b64Encoder;

	static {
		try {
			md = MessageDigest.getInstance("MD5", "SUN");
			b64Encoder = new BASE64Encoder();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 检查密码
	 * 
	 * @param inputPasswd
	 *            用户输入的密码
	 * @param storePasswd
	 *            已存储的密码
	 * @return true:通过检查,false:未通过
	 * @throws UnsupportedEncodingException 
	 */
	synchronized public static boolean checkPassword(String inputPasswd, String storePasswd, byte[] salt) throws UnsupportedEncodingException {
		boolean ok = false;
		String inPwd = encryptPasswd(inputPasswd, salt);
		ok = inPwd.equals(storePasswd);
		return ok;
	}

	/**
	 * 将客户输入的密码加密
	 * 
	 * @param inputPasswd
	 *            客户输入的密码
	 * @param salt
	 *            盐
	 * @return 加密后的字符串
	 * @throws UnsupportedEncodingException
	 */
	synchronized public static String encryptPasswd(String inputPasswd, byte[] salt)
			throws UnsupportedEncodingException {
		String pwd = "";
		md.reset();
		md.update(salt);
		md.update(inputPasswd.getBytes("UTF-8"));
		byte[] bys = md.digest();
		for (byte c : salt) {
			pwd += c;
		}
		System.out.println("salt to pwd = " + pwd);
		pwd += b64Encoder.encode(bys);
		return pwd;
	}

	/**
	 * 返回指定长度的盐(ASCII码)
	 * 
	 * @param len
	 *            长度
	 * @return
	 */
	public static byte[] generateSaltOfASCII(int len) {
		byte[] salt = new byte[len];
		Random rand = new Random();
		for (int i = 0; i < len; i++) {
			salt[i] = (byte) ((rand.nextInt('~' - '!') + '!') & 0x007f);
		}
		return salt;
	}
	
	
	public static void main(String args[]) {
		
		String inPw = "000000";
		byte[] gensalt = PasswordEncryption.generateSaltOfASCII(8);
		byte[] gensalt2 = PasswordEncryption.generateSaltOfASCII(8);
		byte[] gensalt3 = PasswordEncryption.generateSaltOfASCII(8);
		byte[] gensalt4 = PasswordEncryption.generateSaltOfASCII(8);
		System.out.println("gensalt=" + gensalt);
		System.out.println("gensalt2=" + gensalt2);
		System.out.println("gensalt3=" + gensalt3);
		System.out.println("gensalt4=" + gensalt4);
		
		try {
			String storePw = PasswordEncryption.encryptPasswd(inPw, gensalt);
			String storePw2 = PasswordEncryption.encryptPasswd(inPw, gensalt2);
			String storePw3 = PasswordEncryption.encryptPasswd(inPw, gensalt3);
			String storePw4 = PasswordEncryption.encryptPasswd(inPw, gensalt4);
			System.out.println("加密后：" + storePw);
			System.out.println("加密后：" + storePw2);
			System.out.println("加密后：" + storePw3);
			System.out.println("加密后：" + storePw4);
			
			boolean isOk = PasswordEncryption.checkPassword(inPw, storePw, gensalt);
			boolean isOk2 = PasswordEncryption.checkPassword(inPw, storePw2, gensalt2);
			boolean isOk3 = PasswordEncryption.checkPassword(inPw, storePw3, gensalt3);
			boolean isOk4 = PasswordEncryption.checkPassword(inPw, storePw4, gensalt4);
			System.out.println("isOk=" + isOk);
			System.out.println("isOk2=" + isOk2);
			System.out.println("isOk3=" + isOk3);
			System.out.println("isOk4=" + isOk4);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}