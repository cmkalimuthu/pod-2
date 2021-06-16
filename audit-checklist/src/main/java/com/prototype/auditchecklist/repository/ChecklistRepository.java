package com.prototype.auditchecklist.repository;
/**
 * 
 * This interface communicates with db to fetch the questions.
 *
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.auditchecklist.model.QuestionsEntity;

@Repository
public interface ChecklistRepository extends JpaRepository<QuestionsEntity, Integer>{
	/**
	 * 
	 * @param i
	 * @return
	 */
	
	List<QuestionsEntity> findByAuditType(String auditType);

}
