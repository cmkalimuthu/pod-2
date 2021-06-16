package com.prototype.auditseverity.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prototype.auditseverity.feignclients.AuditBenchmarkFeign;
import com.prototype.auditseverity.feignclients.AuditCheckListFeign;
import com.prototype.auditseverity.feignclients.AuthClient;
import com.prototype.auditseverity.model.AuditRequest;
import com.prototype.auditseverity.model.QuestionsEntity;
import com.prototype.auditseverity.pojo.AuditBenchmark;
import com.prototype.auditseverity.pojo.AuditType;
import com.prototype.auditseverity.service.RequestResponseService;
import com.prototype.auditseverity.service.TokenService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration
@Slf4j
public class SeverityControllerTest {

	@Mock
	private RequestResponseService service;

	@Mock
	AuthClient authClient;

	@Mock
	AuditCheckListFeign checklistFeign;

	@Mock
	AuditRequest auditRequest;

	@Mock
	TokenService tokenService;

	@Mock
	AuditBenchmarkFeign auditBenchmarkFeign;

	@InjectMocks
	SeverityController severityController;

	@Test
	public void contextLoad() {
		assertNotNull(severityController);
	}

	@Test
	public void testExecutionStatus() {
		log.info("start");
		List<QuestionsEntity> questionsEntity = new ArrayList<>();
		questionsEntity.add(new QuestionsEntity(1, "Internal", "ABC", "No"));
		questionsEntity.add(new QuestionsEntity(2, "Internal", "DEF", "No"));
		questionsEntity.add(new QuestionsEntity(3, "Internal", "PQR", "Yes"));
		questionsEntity.add(new QuestionsEntity(4, "Internal", "STU", "Yes"));
		questionsEntity.add(new QuestionsEntity(5, "Internal", "QWF", "Yes"));

		ResponseEntity<List<QuestionsEntity>> questionsList = new ResponseEntity<List<QuestionsEntity>>(questionsEntity,
				HttpStatus.OK);
		List<AuditBenchmark> auditBenchmarkList = new ArrayList<AuditBenchmark>();
		auditBenchmarkList.add(new AuditBenchmark("Internal", 3));
		auditBenchmarkList.add(new AuditBenchmark("SOX", 1));
		ResponseEntity<List<AuditBenchmark>> responseEntity = new ResponseEntity<List<AuditBenchmark>>(
				auditBenchmarkList, HttpStatus.OK);
		AuditType auditType = new AuditType("Internal");

		when(tokenService.checkTokenValidity("token")).thenReturn(true);
		when(auditBenchmarkFeign.getBenchMark("token")).thenReturn(responseEntity);
		when(checklistFeign.getQuestions("token", auditType)).thenReturn(questionsList);
		log.info("end");

	}

	@Test
	public void testAuditSeverityTokenFails() {
		when(tokenService.checkTokenValidity("token")).thenReturn(false);
		assertEquals(HttpStatus.FORBIDDEN,
				severityController.getExceutionStatus("token", new AuditRequest()).getStatusCode());

	}

}
