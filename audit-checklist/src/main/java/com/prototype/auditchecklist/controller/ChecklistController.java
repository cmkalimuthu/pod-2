package com.prototype.auditchecklist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.auditchecklist.exception.InvalidAuditTypeException;
import com.prototype.auditchecklist.model.QuestionsEntity;
import com.prototype.auditchecklist.pojo.AuditType;
import com.prototype.auditchecklist.service.TokenService;
import com.prototype.auditchecklist.service.checklistService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * This class is handling all the end points for Audit Checklist microservice.
 * This controller has mappings as- postmapping-getQuestions()
 * postmapping-saveRespose()
 *
 */

@RestController
@Slf4j
public class ChecklistController {

	/**
	 * 
	 * @param token
	 * @param auditType
	 * @return ResponseEntity<Response>
	 * 
	 *         Returns the Questions according to the User's input whether he has
	 *         chosen Internal or SOX audit type
	 *
	 */
	@Autowired
	checklistService service;

	@Autowired
	TokenService tokenService;
	
	final String inValidAuditType="invalid audit type";
	final String tokenExpired="the token is expired and not valid anymore";

	@PostMapping("/checklist")
	public ResponseEntity<?> getQuestions(@RequestHeader(name = "Authorization", required = true) String token,
			@RequestBody AuditType auditType) {
		log.info("start");
		List<QuestionsEntity> questionsList = new ArrayList<>();
		ResponseEntity<?> responseEntity;
		if (tokenService.checkTokenValidity(token)) {
			try {
				questionsList = service.getQuestions(auditType.getAuditType());
			} catch (InvalidAuditTypeException e) {
				responseEntity = new ResponseEntity<String>(inValidAuditType, HttpStatus.INTERNAL_SERVER_ERROR);
				return responseEntity;
			}
			responseEntity = new ResponseEntity<List<QuestionsEntity>>(questionsList, HttpStatus.OK);
			return responseEntity;

		} else {
			log.error("token expired");
			log.info("end");
			responseEntity = new ResponseEntity<String>(tokenExpired,
					HttpStatus.FORBIDDEN);
			return responseEntity;
		}

	}

	/**
	 * 
	 * @param token
	 * @param questionsResponse
	 * @return ResponseEntity
	 * 
	 *         This is storing the responses of the Internal/SOX Audit Questions
	 *         into the database.
	 * 
	 */
	@PostMapping("/saveResponse")
	public ResponseEntity<?> saveRespose(@RequestHeader(name = "Authorization", required = true) String token,
			@RequestBody List<QuestionsEntity> questionsResponse) {
		log.info("start");
		List<QuestionsEntity> questionsList = new ArrayList<>();
		ResponseEntity<?> responseEntity;
		if (tokenService.checkTokenValidity(token)) {
			questionsList = service.saveResponse(questionsResponse);
			responseEntity = new ResponseEntity<List<QuestionsEntity>>(questionsList, HttpStatus.OK);
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
