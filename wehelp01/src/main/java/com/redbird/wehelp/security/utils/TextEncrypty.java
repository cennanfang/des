package com.redbird.wehelp.security.utils;

import java.io.Serializable;
import java.security.Key;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;

public class TextEncrypty implements Serializable{
	
	private static final long serialVersionUID = 6142182583848603482L;

	private AesCipherService aesCipherService;
	
	private Key key;
	
	public TextEncrypty() {
		this(128);
	}
	
	public TextEncrypty(int keySize) {
		aesCipherService = new AesCipherService();
		aesCipherService.setKeySize(keySize);
		key = aesCipherService.generateNewKey(); 
	}
	
	public Key getKey() {
		return key;
	}

	/**
	 * 加密
	 * @param text
	 * @param keySize
	 */
	public String encrypt(String text) {
		//加密  
		String encrptText = aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();  
		return encrptText;
	}
	
	/**
	 * 解密
	 * @param text
	 * @param keySize
	 */
	public String decrypt(String encrptText) {
		String decryptText=  new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());  
		return decryptText;
	}
	
	public static TextEncrypty getTextEncrypty() {
		TextEncrypty textEncrypty = new TextEncrypty();
		return textEncrypty;
	}
	
	public static TextEncrypty getTextEncrypty(int keySize) {
		TextEncrypty textEncrypty = new TextEncrypty(keySize);
		return textEncrypty;
	}
	
}