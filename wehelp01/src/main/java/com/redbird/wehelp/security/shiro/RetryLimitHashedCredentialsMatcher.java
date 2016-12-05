package com.redbird.wehelp.security.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.ByteSource;

import com.redbird.wehelp.security.utils.EncryptionUtils;
import com.redbird.wehelp.security.utils.PasswdUtils;
import com.redbird.wehelp.utils.DataUtils;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicInteger;


public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        String username = (String)authcToken.getPrincipal();
        //retry count + 1
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if(retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        if(retryCount.incrementAndGet() > 5) {
            //if retry count > 5 throw
            throw new ExcessiveAttemptsException();
        }

        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		SimpleAuthenticationInfo sai = (SimpleAuthenticationInfo) info;
		String tokenCredentials = String.valueOf(token.getPassword());
		String accountCredentials = (String)getCredentials(info);
		ByteSource salt = sai.getCredentialsSalt();
		boolean matches = false;
		try {
			String storePasswd = EncryptionUtils.base64Decode(accountCredentials);
			String saltStr = EncryptionUtils.hexDecode(DataUtils.byteArrayToString(salt.getBytes()));
			matches = PasswdUtils.checkPassword(tokenCredentials, storePasswd, saltStr);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        if(matches) {
            //clear retry count
            passwordRetryCache.remove(username);
        }
        return matches;
    }
    
    @Override
    protected Object getCredentials(AuthenticationInfo info) {
    	return  info.getCredentials();
    }
}
