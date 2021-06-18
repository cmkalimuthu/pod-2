package com.prototype.auditwebportal.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * This is a POJO class used to store details entered by Project Manager/User
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class AuditRequest {
	/**
	 * Variable projectName is used to store the Name of the Project
	 */
	private String projectName;
	/**
	 * Variable projectManagerName is used to store the Manager Name of the Project
	 */
	private String managerName;
	/**
	 * Variable applicationOwnerName is used to store the Application Owner Name of the Project
	 */
	private String ownerName;
	/**
	 * Variable auditDetails is used to store the AuditDetails of the Project
	 */
	private AuditDetails auditDetails;
}
