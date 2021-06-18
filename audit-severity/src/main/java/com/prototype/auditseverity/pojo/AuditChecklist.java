package com.prototype.auditseverity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 *This POJO class is for AuditChecklist
 *
 */
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuditChecklist {
	/**
	 * Variable questionId is used to store the QuestionID
	 */
	private int questionId;
	/**
	 * Variable auditType is used to store the Audit Type
	 */
	private String auditType;
	/**
	 * Variable question is used to store the Question
	 */
	private String questions;
	/**
	 * Variable response is used to store the Response of the question
	 */
	private String response;
}
