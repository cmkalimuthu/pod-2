package com.prototype.auditseverity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * 
 *This POJO class is for AuditBenchMark
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AuditBenchmark {
	
	/**
	 * Variable auditType is used to store the type of Audit
	 */
	private String auditType;
	/**
	 * Variable accNoAnswers is used to store the No Answers
	 */
	private int noOfnos;
	
}