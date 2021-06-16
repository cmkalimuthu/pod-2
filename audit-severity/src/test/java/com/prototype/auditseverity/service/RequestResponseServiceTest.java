package com.prototype.auditseverity.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prototype.auditseverity.feignclients.AuditBenchmarkFeign;
import com.prototype.auditseverity.feignclients.AuditCheckListFeign;
import com.prototype.auditseverity.model.AuditResponse;
import com.prototype.auditseverity.repository.ResponseRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration
@Slf4j
public class RequestResponseServiceTest {

	@InjectMocks
	RequestResponseService requestResponseService;

	@Mock
	RequestResponseService req1;

	@Mock
	AuditCheckListFeign auditCheckListFeign;

	@Mock
	AuditBenchmarkFeign auditBenchmarkFeign;

	@Mock
	ResponseRepository responseRepository;

	@Test
	public void saveResponseTest() {
		log.info("start");
		Date auditDate = new Date();
		AuditResponse response = new AuditResponse(1, "GREEN", "No action required", " projectName", "managerName",
				"ownerName", "auditType2", auditDate);
		AuditResponse response1 = new AuditResponse(1, response.getExecutionStatus(), response.getDuration(),
				response.getProjectName(), response.getManagerName(), response.getOwnerName(), response.getAuditType(),
				response.getAuditDate());
		when(responseRepository.save(response1)).thenReturn(response1);
		assertEquals(response1, requestResponseService.saveResponse(response));
		log.info("end");

	}

}
