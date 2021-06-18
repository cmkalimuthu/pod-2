package com.prototype.auditchecklist.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * This model class is used for validation of token 
 * for authorization 
 *
 */

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

	/**
	 * Variable uId is used to store the uId for user login
	 * credentials. The data type is String.
	 */
	
	private String uid;

	/**
	 * Variable isValid is used to store whether the token is valid
	 * or not. The data type is boolean.
	 */
	
	private boolean isValid;
	}
