package com.prototype.auditseverity.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prototype.auditseverity.model.QuestionsEntity;

/*
This POJO class is for AuditchecklistTest
*/

@RunWith(SpringRunner.class)
@ContextConfiguration
public class AuditChecklistTest {

	QuestionsEntity questions=new QuestionsEntity();
	
	/*
	 * Here this method used to test the parameterized constructor
	 */
	@Test
	public void testParameterizedConstructor() {
		QuestionsEntity questions=new QuestionsEntity(1,"SOX","Have all changes has been approved","Yes");
	    assertEquals("Yes",questions.getResponse());
	}
	
	/*
	 * Here this method used to test the QuestionId by get and set method
	 */
	@Test
	public void testQuestionId() {
		questions.setQuestionId(2);
		assertEquals(2,questions.getQuestionId());
	}
	
	/*
	 * Here this method used to test the type of audit by get and set method
	 */
	@Test
	public void testQuestionType() {
		questions.setAuditType("Internal");
		assertEquals("Internal",questions.getAuditType());
	}
	
	/*
	 * Here this method used to test the Question by get and set method
	 */
	@Test
	public void testQuestion() {
		questions.setQuestions("Do you have any changes?");
		assertEquals("Do you have any changes?",questions.getQuestions());
	}
	
	/*
	 * Here this method used to test the response by get and set method
	 */
	@Test
	public void testResponse() {
		questions.setResponse("No");
		assertEquals("No",questions.getResponse());
	}
	
	
}