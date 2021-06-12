package com.prototype.auditseverity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.auditseverity.model.AuditRequest;
import com.prototype.auditseverity.model.AuditResponse;
import com.prototype.auditseverity.model.QuestionsEntity;
import com.prototype.auditseverity.pojo.AuditBenchmark;
import com.prototype.auditseverity.service.RequestResponseService;

@RestController
public class SeverityController {

	@Autowired
	RequestResponseService requestResponseService;

	@Autowired
	Environment env;

	@PostMapping("/execution-status")
	public AuditResponse getExceutionStatus(@RequestBody AuditRequest request) {

		int noNos = 0;
		if (!request.equals(null))
			requestResponseService.saveRequest(request);
		AuditResponse response = null;
		String auditType = request.getAuditDetails().getAuditType();
		ResponseEntity<List<QuestionsEntity>> allQuestions = requestResponseService.getAllQuestions(auditType);

		for (QuestionsEntity qs1 : allQuestions.getBody()) {
			System.out.println("inside questions" + qs1);
			if (qs1.getAuditType().equals(auditType) && qs1.getResponse().equals("NO")) {
				noNos++;
			}
		}

		ArrayList<AuditBenchmark> auditBenchmark = requestResponseService.getAuditBenchmark();
		int actualNos = 0;
		for (AuditBenchmark bench : auditBenchmark) {
			if (bench.getAuditType().equals(auditType))
				actualNos = bench.getNoOfnos();
		}

		if (auditType.equalsIgnoreCase("internal") && noNos <= actualNos) {
			response = new AuditResponse(1, "green", "no action required");
		} else if (auditType.equalsIgnoreCase("internal") && noNos > actualNos) {
			response = new AuditResponse(2, "red", "Action to be taken in 2 weeks");
		} else if (auditType.equalsIgnoreCase("sox") && noNos <= actualNos) {
			response = new AuditResponse(3, "green", "no action needed");
		} else if (auditType.equalsIgnoreCase("sox") && noNos > actualNos) {
			response = new AuditResponse(4, "red", "Action to be taken in 1 weeks");
		}
		requestResponseService.saveResponse(response);
		return response;
	}

}
