package com.redbird.wehelp.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Random;

import sun.misc.BASE64Encoder;

/**
 * ���ʺſ���ǰ����
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
	 * �������
	 * 
	 * @param inputPasswd
	 *            �û����������
	 * @param storePasswd
	 *            �Ѵ洢������
	 * @return true:ͨ�����,false:δͨ��
	 * @throws UnsupportedEncodingException 
	 */
	synchronized public static boolean checkPassword(String inputPasswd, String storePasswd, byte[] salt) throws UnsupportedEncodingException {
		boolean ok = false;
		String inPwd = encryptPasswd(inputPasswd, salt);
		ok = inPwd.equals(storePasswd);
		return ok;
	}

	/**
	 * ���ͻ�������������
	 * 
	 * @param inputPasswd
	 *            �ͻ����������
	 * @param salt
	 *            ��
	 * @return ���ܺ���ַ���
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
	 * ����ָ�����ȵ���(ASCII��)
	 * 
	 * @param len
	 *            ����
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
		
		String inPw = "123456";
		byte[] gensalt = PasswordEncryption.generateSaltOfASCII(8);
		byte[] gensalt2 = PasswordEncryption.generateSaltOfASCII(8);
		byte[] gensalt3 = PasswordEncryption.generateSaltOfASCII(8);
		System.out.println("gensalt=" + gensalt);
		System.out.println("gensalt2=" + gensalt2);
		System.out.println("gensalt3=" + gensalt3);
		
		try {
			String storePw = PasswordEncryption.encryptPasswd(inPw, gensalt);
			String storePw2 = PasswordEncryption.encryptPasswd(inPw, gensalt2);
			String storePw3 = PasswordEncryption.encryptPasswd(inPw, gensalt3);
			System.out.println("���ܺ�" + storePw);
			System.out.println("���ܺ�" + storePw2);
			System.out.println("���ܺ�" + storePw3);
			
			boolean isOk = PasswordEncryption.checkPassword(inPw, storePw, gensalt);
			boolean isOk2 = PasswordEncryption.checkPassword(inPw, storePw2, gensalt2);
			boolean isOk3 = PasswordEncryption.checkPassword(inPw, storePw3, gensalt3);
			System.out.println("isOk=" + isOk);
			System.out.println("isOk2=" + isOk2);
			System.out.println("isOk3=" + isOk3);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}