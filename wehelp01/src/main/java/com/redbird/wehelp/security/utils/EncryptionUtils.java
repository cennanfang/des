package com.redbird.wehelp.security.utils;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;

import com.redbird.wehelp.utils.DataUtils;

/**
 * 数据加密解密
 * @author cennanfang
 *
 */
public class EncryptionUtils {

	/**
	 * 
	 * @param inputs
	 * @return
	 */
	synchronized public static String base64Encode(String inputs) {
		byte[] outputs = Base64.encode(inputs.getBytes());
		return DataUtils.byteArrayToString(outputs);
	}
	
	/**
	 * 
	 * @param inputs
	 * @return
	 */
	synchronized public static String base64Decode(String inputs) {
		byte[] outputs = Base64.decode(inputs.getBytes());
		return DataUtils.byteArrayToString(outputs);
	}
	
	/**
	 * 
	 * @param inputs
	 * @return
	 */
	synchronized public static String hexEncode(String inputs) {
		char[] outputs = Hex.encode(inputs.getBytes());
		return String.valueOf((outputs));
	}
	
	/**
	 * 
	 * @param inputs
	 * @return
	 */
	synchronized public static String hexDecode(String inputs) {
		byte[] outputs = Hex.decode(inputs.toCharArray());
		return DataUtils.byteArrayToString(outputs);
	}
}
