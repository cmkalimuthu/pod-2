package com.prototype.auditchecklist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.auditchecklist.model.QuestionsEntity;
import com.prototype.auditchecklist.repository.ChecklistRepository;
/**
 * @version 1.8
 * 			This class is used to load the questions from database and
 *          checking whether the question resides in database or not based on the
 *          given id.
 *
 */
@Service
public class checklistService {

	@Autowired
	ChecklistRepository repository;
	/**
	 * 
	 * @param auditType
	 * @return List
	 * @throws IndexOutOfBoundsException
	 */
	
	
	public List<QuestionsEntity> getQuestions(String auditType)throws IndexOutOfBoundsException{
		if(repository.findByAuditType(auditType).isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		else {
			return repository.findByAuditType(auditType);
		}
	}
	
	/**
	 * 
	 * @param responses
	 * @return List
	 */
	public List<QuestionsEntity> saveResponse(List<QuestionsEntity> responses){
		return repository.saveAll(responses);
	}
	
}
