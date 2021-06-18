package com.prototype.auditwebportal.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * This is a POJO class used to store the Audit related info and execution status
 */
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuditResponse {

	private int auditId;
	private String executionStatus;
	private String duration;
	private String projectName;
	private String managerName;
	private String ownerName;
	private String auditType;
	private Date auditDate;
}
