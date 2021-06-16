package com.prototype.auditchecklist.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * 
 *		   This class contains test cases for the QuestionsEntity model class
 *         which are written using junit and mockito
 */


@RunWith(SpringRunner.class)
@ContextConfiguration
public class QuestionsEntityTest {
	/**
	 * 
	 * test the allArgsConstructor of QuestionsEntity model class
	 */
	QuestionsEntity questions=new QuestionsEntity();
	
	/**
	 * 
	 * test the QuestionsEntityParameterizedConstructor of QuestionsEntity model class
	 */
	
	@Test
	public void testParameterizedConstructor() {
		QuestionsEntity questions=new QuestionsEntity(1,"SOX","Have all changes has been approved","Yes");
	    assertEquals("Yes",questions.getResponse());
	}
	
	/**
	 * 
	 * test the Getter and Setter of Question id in QuestionsEntity model class
	 */
	@Test
	public void testQuestionId() {
		questions.setQuestionId(2);
		assertEquals(2,questions.getQuestionId());
	}
	
	/**
	 * 
	 * test the Getter and Setter of Audit Type in QuestionsEntity model class
	 */
	@Test
	public void testQuestionType() {
		questions.setAuditType("Internal");
		assertEquals("Internal",questions.getAuditType());
	}
	
	/**
	 * 
	 * test the Getter and Setter of Question in QuestionsEntity model class
	 */
	@Test
	public void testQuestion() {
		questions.setQuestions("Do you have any changes?");
		assertEquals("Do you have any changes?",questions.getQuestions());
	}
	/**
	 * 
	 * test the Getter and Setter of Response in QuestionsEntity model class
	 */
	@Test
	public void testResponse() {
		questions.setResponse("No");
		assertEquals("No",questions.getResponse());
	}
	
	
}