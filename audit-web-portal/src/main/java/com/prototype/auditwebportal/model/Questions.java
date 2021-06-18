package com.prototype.auditwebportal.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * This is a class used to store the questions details

 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Questions {
	
	private List<QuestionsEntity> questionsEntity;
}
