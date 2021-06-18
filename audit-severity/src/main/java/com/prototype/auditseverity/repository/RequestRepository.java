package com.prototype.auditseverity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.auditseverity.model.AuditRequest;

/**
 * 
 * This interface communicates with db to fetch the audit request details
 *
 */

@Repository
public interface RequestRepository extends JpaRepository<AuditRequest, Integer>{

}
