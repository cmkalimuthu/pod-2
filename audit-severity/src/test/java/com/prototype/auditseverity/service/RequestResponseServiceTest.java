package com.prototype.auditseverity.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prototype.auditseverity.feignclients.AuditBenchmarkFeign;
import com.prototype.auditseverity.feignclients.AuditCheckListFeign;
import com.prototype.auditseverity.model.AuditResponse;
import com.prototype.auditseverity.model.QuestionsEntity;
import com.prototype.auditseverity.pojo.AuditBenchmark;
import com.prototype.auditseverity.pojo.AuditType;
import com.prototype.auditseverity.repository.ResponseRepository;
import com.prototype.auditseverity.service.RequestResponseService;

@RunWith(SpringRunner.class)
@ContextConfiguration
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
		AuditResponse response = new AuditResponse(1,"GREEN","No action required");
		AuditResponse response1 = new AuditResponse(1,response.getExecutionStatus(),response.getDuration());
		when(responseRepository.save(response1)).thenReturn(response1);
		assertEquals(response1, requestResponseService.saveResponse(response));
		
	}
	

	
	

	
	
	

	
}
