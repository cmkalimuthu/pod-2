package com.prototype.auditseverity.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.auditseverity.feignclients.AuditBenchmarkFeign;
import com.prototype.auditseverity.feignclients.AuditCheckListFeign;
import com.prototype.auditseverity.model.AuditRequest;
import com.prototype.auditseverity.model.AuditResponse;
import com.prototype.auditseverity.model.QuestionsEntity;
import com.prototype.auditseverity.pojo.AuditBenchmark;
import com.prototype.auditseverity.pojo.AuditType;
import com.prototype.auditseverity.service.RequestResponseService;
import com.prototype.auditseverity.service.TokenService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * This class is handling all the end points for Audit Checklist and audit benchmark microservices.
 * This controller has mappings as- postmapping-getExecutionStatus()
 *
 */

@RestController
@Slf4j
public class SeverityController {

	@Autowired
	RequestResponseService requestResponseService;

	@Autowired
	Environment env;

	@Autowired
	AuditBenchmarkFeign auditBenchmarkFeign;

	@Autowired
	AuditCheckListFeign auditCheckListFeign;

	@Autowired
	TokenService tokenService;
	
	final String internal="Internal";
	final String sox="SOX";
	final String greenStatus="Green";
	final String redStatus="Red";
	final String week2="Action to be taken in 2 weeks";
	final String week1="Action to be taken in 1 weeks";
	final String noAction="No action required";
	final String tokenExpired="the token is expired and not valid anymore";
	

	/**
	 * 
	 * @param token
	 * @param auditRequest
	 * @return ResponseEntity<Response>
	 */

	@PostMapping("/executionStatus")
	public ResponseEntity<?> getExceutionStatus(@RequestHeader(name = "Authorization", required = true) String token,
			@RequestBody AuditRequest request) {
		log.info("start");
		log.debug("Auditrequest",request);
		ResponseEntity<?> responseEntity = null;
		List<QuestionsEntity> questionsList = null;
		AuditResponse response = null;
		int noNos = 0;
		int actualNos = 0;
		String managerName = request.getManagerName();
		String projectName = request.getProjectName();
		String auditType2 = request.getAuditDetails().getAuditType();
		Date auditDate = request.getAuditDetails().getAuditDate();
		String ownerName = request.getOwnerName();


		if (tokenService.checkTokenValidity(token)) {
			List<AuditBenchmark> benchmarkList = auditBenchmarkFeign.getBenchMark(token).getBody();
			for (AuditBenchmark benchmark : benchmarkList) {
				if (benchmark.getAuditType().equalsIgnoreCase(request.getAuditDetails().getAuditType())) {
					actualNos = benchmark.getNoOfnos();
				}

			}
			
			AuditType auditType = new AuditType(request.getAuditDetails().getAuditType());
			questionsList = auditCheckListFeign.getQuestions(token, auditType).getBody();

			for (QuestionsEntity qs1 : questionsList) {
				if (qs1.getAuditType().equals(auditType.getAuditType()) && qs1.getResponse().equals("NO")) {
					noNos++;
				}
			}

			if (auditType.getAuditType().equalsIgnoreCase(internal) && noNos <= actualNos) {
				response = new AuditResponse(1, greenStatus, noAction, projectName, managerName, ownerName,
						auditType2, auditDate);
			} else if (auditType.getAuditType().equalsIgnoreCase(internal) && noNos > actualNos) {
				response = new AuditResponse(2, redStatus, week2, projectName, managerName,
						ownerName, auditType2, auditDate);
			} else if (auditType.getAuditType().equalsIgnoreCase(sox) && noNos <= actualNos) {
				response = new AuditResponse(3, greenStatus, noAction, projectName, managerName, ownerName,
						auditType2, auditDate);
			} else if (auditType.getAuditType().equalsIgnoreCase(sox) && noNos > actualNos) {
				response = new AuditResponse(4, redStatus, week1, projectName, managerName,
						ownerName, auditType2, auditDate);
			}
			requestResponseService.saveResponse(response);
			requestResponseService.saveRequest(request);
			responseEntity = new ResponseEntity<AuditResponse>(response, HttpStatus.OK);
			return responseEntity;
		} else {
			log.error("token expired");
			log.info("end");
			responseEntity = new ResponseEntity<String>(tokenExpired,
					HttpStatus.FORBIDDEN);
			return responseEntity;
		}

	}
}