package com.prototype.auditchecklist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.auditchecklist.exception.InvalidAuditTypeException;
import com.prototype.auditchecklist.model.QuestionsEntity;
import com.prototype.auditchecklist.repository.ChecklistRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @version 1.8 This class is used to load the questions from database and
 *          checking whether the question resides in database or not based on
 *          the given id.
 *
 */
@Service
@Slf4j
public class checklistService {

	@Autowired
	ChecklistRepository repository;

	/**
	 * 
	 * @param auditType
	 * @return List
	 * @throws IndexOutOfBoundsException
	 */

	public List<QuestionsEntity> getQuestions(String auditType) throws InvalidAuditTypeException {
		log.info("start");
		if (repository.findByAuditType(auditType).isEmpty()) {
			throw new InvalidAuditTypeException("invalid audit type");
		} else {
			log.info("end");
			return repository.findByAuditType(auditType);
		}
	}

	/**
	 * 
	 * @param responses
	 * @return List
	 */
	public List<QuestionsEntity> saveResponse(List<QuestionsEntity> responses) {
		return repository.saveAll(responses);
	}

	
	
	

}
