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

@RestController
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

	@PostMapping("/execution-status")
	public ResponseEntity<?> getExceutionStatus(@RequestHeader(name = "Authorization", required = true) String token,
			@RequestBody AuditRequest request) {
		int noNos = 0;
		int actualNos = 0;
		String managerName = request.getManagerName();
		String projectName = request.getProjectName();
		String auditType2 = request.getAuditDetails().getAuditType();
		Date auditDate = request.getAuditDetails().getAuditDate();
		String ownerName = request.getOwnerName();
		
		ResponseEntity<?> responseEntity = null;
		List<QuestionsEntity> questionsList = null;
		if (tokenService.checkTokenValidity(token)) {
			List<AuditBenchmark> benchmarkList = auditBenchmarkFeign.getBenchMark(token).getBody();
			for (AuditBenchmark benchmark : benchmarkList) {
				if (benchmark.getAuditType().equalsIgnoreCase(request.getAuditDetails().getAuditType())) {
					actualNos = benchmark.getNoOfnos();
				}

			}
			AuditResponse response = null;
			System.out.println("request " + request.toString());
			AuditType auditType = new AuditType(request.getAuditDetails().getAuditType());
			questionsList = auditCheckListFeign.getQuestions(token, auditType).getBody();

			for (QuestionsEntity qs1 : questionsList) {
				System.out.println("inside questions" + qs1);
				System.out.println("questions " + qs1);
				if (qs1.getAuditType().equals(auditType.getAuditType()) && qs1.getResponse().equals("NO")) {
					noNos++;
				}
			}
			System.out.println("actual no" + actualNos);
			System.out.println("response nos" + noNos);
			if (auditType.getAuditType().equals("Internal") && noNos <= actualNos) {
				response = new AuditResponse(1, "green", "no action required", projectName, managerName,ownerName,auditType2,auditDate);
			} else if (auditType.getAuditType().equals("Internal") && noNos > actualNos) {
				response = new AuditResponse(2, "red", "Action to be taken in 2 weeks", projectName, managerName,ownerName,auditType2,auditDate);
			} else if (auditType.getAuditType().equals("SOX") && noNos <= actualNos) {
				response = new AuditResponse(3, "green", "no action needed", projectName, managerName,ownerName,auditType2,auditDate);
			} else if (auditType.getAuditType().equals("SOX") && noNos > actualNos) {
				response = new AuditResponse(4, "red", "Action to be taken in 1 weeks", projectName, managerName,ownerName,auditType2,auditDate);
			}
			requestResponseService.saveResponse(response);
			requestResponseService.saveRequest(request);
			responseEntity = new ResponseEntity<AuditResponse>(response, HttpStatus.OK);
			return responseEntity;
		} else {
			responseEntity = new ResponseEntity<String>("the token is expired and not valid anymore",
					HttpStatus.FORBIDDEN);
			return responseEntity;
		}

	}
}