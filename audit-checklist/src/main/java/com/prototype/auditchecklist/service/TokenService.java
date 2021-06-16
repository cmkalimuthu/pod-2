package com.prototype.auditchecklist.service;
/**
 * 
 * This class is implementing {@link TokenService}.
 * The method of this class is used in other classes to validate token received.
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.auditchecklist.exception.FeignProxyException;
import com.prototype.auditchecklist.feignclients.AuthClient;
import com.prototype.auditchecklist.pojo.AuthResponse;

import feign.FeignException;

@Service
public class TokenService implements TokenServiceInt{
	/**
	 * Interface interacting with Auth microservice
	 */
	@Autowired
	private AuthClient authClient;
	
	public Boolean checkTokenValidity(String token)  {
		try {
			AuthResponse authResponse = authClient.getValidity(token).getBody();
			if(authResponse==null) throw new FeignProxyException();
			return authResponse.isValid();	
		}catch (FeignProxyException fe) {
			return false;
		}
		catch(FeignException e) {
			return false;
		}
	}
}
