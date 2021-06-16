package com.prototype.auditchecklist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.auditchecklist.model.QuestionsEntity;
import com.prototype.auditchecklist.pojo.AuditType;
import com.prototype.auditchecklist.service.TokenService;
import com.prototype.auditchecklist.service.checklistService;

/**
 * 
 * This class is handling all the end points for Audit Checklist microservice. 
 * This controller has mappings as-
 * 			postmapping-getQuestions()
 * 			postmapping-saveRespose()
 *
 */

@RestController
public class ChecklistController {
	
	/**
     * 
     * @param token
     * @param auditType
     * @return ResponseEntity<Response>
     * 
     * Returns the Questions according to the User's input whether he has chosen Internal or SOX audit type
	 *
     */
	@Autowired
	checklistService service;
	
	@Autowired
	TokenService tokenService;

	@PostMapping("/checklist")
	public ResponseEntity<?> getQuestions(@RequestHeader(name = "Authorization",required = true)String token,@RequestBody AuditType auditType){
		List<QuestionsEntity> questionsList = new ArrayList<>();
		ResponseEntity<?> responseEntity;
		if(tokenService.checkTokenValidity(token)) {
			System.out.println("In checklist" + auditType.getAuditType());
			try {
			questionsList = service.getQuestions(auditType.getAuditType());
			}catch(IndexOutOfBoundsException e) {
				responseEntity= new ResponseEntity<String>("invalid audit type",HttpStatus.INTERNAL_SERVER_ERROR);
				return responseEntity;
			}
			responseEntity = new ResponseEntity<List<QuestionsEntity>>(questionsList,HttpStatus.OK);
			System.out.println(questionsList);
			return responseEntity;
			
		}
		else {			
			responseEntity= new ResponseEntity<String>("the token is expired and not valid anymore",HttpStatus.FORBIDDEN);
			return responseEntity;
		}
			
		
	}
	/**
	 * 
	 * @param token
	 * @param questionsResponse
	 * @return ResponseEntity 
	 * 
	 * This is storing the responses of the Internal/SOX Audit Questions into the database.
	 * 
	 */
	@PostMapping("/save-response")
	public ResponseEntity<?> saveRespose(@RequestHeader(name = "Authorization",required = true)String token,@RequestBody List<QuestionsEntity> questionsResponse){
	
		List<QuestionsEntity> questionsList = new ArrayList<>();
		ResponseEntity<?> responseEntity;
		if(tokenService.checkTokenValidity(token)) {
			questionsList = service.saveResponse(questionsResponse);
			responseEntity = new ResponseEntity<List<QuestionsEntity>>(questionsList,HttpStatus.OK);
			return responseEntity;
		}
		else {
			responseEntity= new ResponseEntity<String>("the token is expired and not valid anymore",HttpStatus.FORBIDDEN);
			return responseEntity;
		}
	}
	
		
}
