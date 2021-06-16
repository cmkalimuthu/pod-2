package com.prototype.auditseverity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.auditseverity.feignclients.AuditBenchmarkFeign;
import com.prototype.auditseverity.feignclients.AuditCheckListFeign;
import com.prototype.auditseverity.model.AuditRequest;
import com.prototype.auditseverity.model.AuditResponse;
import com.prototype.auditseverity.repository.AuditDetailRepository;
import com.prototype.auditseverity.repository.RequestRepository;
import com.prototype.auditseverity.repository.ResponseRepository;

@Service
public class RequestResponseService {

	@Autowired
	AuditDetailRepository auditDetailRepository;

	@Autowired
	RequestRepository requestRepository;

	@Autowired
	ResponseRepository responseRepository;

	@Autowired
	AuditCheckListFeign auditCheckListFeign;

	@Autowired
	AuditBenchmarkFeign auditBenchmarkFeign;

	/**
	 * 
	 * @param request
	 * @return AuditRequestModel
	 */
	public AuditRequest saveRequest(AuditRequest request) {
		return requestRepository.save(request);
	}

	/**
	 * 
	 * @param response
	 * @return AuditResponseModel
	 */

	public AuditResponse saveResponse(AuditResponse response) {
		return responseRepository.save(response);
	}

}
