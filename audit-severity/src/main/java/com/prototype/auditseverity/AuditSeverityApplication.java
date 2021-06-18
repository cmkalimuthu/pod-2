package com.prototype.auditseverity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * POD2 -Audit Management System
 * This is Application class for Spring boot
 *
 */
@SpringBootApplication
@EnableFeignClients
public class AuditSeverityApplication {
	/**
	 * main Method- SpringBoot main method to launch an application. 
	 */
	public static void main(String[] args) {
		SpringApplication.run(AuditSeverityApplication.class, args);
	}

}
