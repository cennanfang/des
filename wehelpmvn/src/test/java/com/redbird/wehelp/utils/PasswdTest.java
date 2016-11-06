package com.redbird.wehelp.utils;

import java.io.IOException;

import com.redbird.wehelp.security.utils.EncryptionUtils;
import com.redbird.wehelp.security.utils.PasswdUtils;

public class PasswdTest {

	public static void main(String args[]) {
		generateTestPassword();
	}
	
	public static void generateTestPassword() {
		String inPw = "000000";
		int saltLen = 16;
		String gensalt = PasswdUtils.generateSalt(saltLen);
		String gensalt2 = PasswdUtils.generateSalt(saltLen);
		String gensalt3 = PasswdUtils.generateSalt(saltLen);
		String gensalt4 = PasswdUtils.generateSalt(saltLen);
		
		try {
			String storePw = PasswdUtils.encryptPasswd(inPw, gensalt);
			String storePw2 = PasswdUtils.encryptPasswd(inPw, gensalt2);
			String storePw3 = PasswdUtils.encryptPasswd(inPw, gensalt3);
			String storePw4 = PasswdUtils.encryptPasswd(inPw, gensalt4);
			System.out.println("storePw=" + storePw + "| salt:" + gensalt);
			System.out.println("storePw2=" + storePw2 + "| salt:" + gensalt2);
			System.out.println("storePw3=" + storePw3 + "| salt:" + gensalt3);
			System.out.println("storePw4=" + storePw4 + "| salt:" + gensalt4);
			
			String bpw = EncryptionUtils.base64Encode(storePw);
			String bpw2 = EncryptionUtils.base64Encode(storePw2);
			String bpw3 = EncryptionUtils.base64Encode(storePw3);
			String bpw4 = EncryptionUtils.base64Encode(storePw4);
			String hsalt = EncryptionUtils.hexEncode(gensalt);
			String hsalt2 = EncryptionUtils.hexEncode(gensalt2);
			String hsalt3 = EncryptionUtils.hexEncode(gensalt3);
			String hsalt4 = EncryptionUtils.hexEncode(gensalt4);
			
			System.out.println("bstorePw=" + bpw + "| hsalt:" + hsalt);
			System.out.println("bstorePw2=" + bpw2 + "| hsalt:" + hsalt2);
			System.out.println("bstorePw3=" + bpw3 + "| hsalt:" + hsalt3);
			System.out.println("bstorePw4=" + bpw4 + "| hsalt:" + hsalt4);
			
			boolean isOk = PasswdUtils.checkPassword(inPw, EncryptionUtils.base64Decode(bpw), EncryptionUtils.hexDecode(hsalt));
			boolean isOk2 = PasswdUtils.checkPassword(inPw, EncryptionUtils.base64Decode(bpw2), EncryptionUtils.hexDecode(hsalt2));
			boolean isOk3 = PasswdUtils.checkPassword(inPw, EncryptionUtils.base64Decode(bpw3), EncryptionUtils.hexDecode(hsalt3));
			boolean isOk4 = PasswdUtils.checkPassword(inPw, EncryptionUtils.base64Decode(bpw4), EncryptionUtils.hexDecode(hsalt4));
			
			System.out.println("isOk=" + isOk);
			System.out.println("isOk2=" + isOk2);
			System.out.println("isOk3=" + isOk3);
			System.out.println("isOk4=" + isOk4);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
