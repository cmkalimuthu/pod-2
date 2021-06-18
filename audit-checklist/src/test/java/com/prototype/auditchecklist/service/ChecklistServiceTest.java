package com.prototype.auditchecklist.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prototype.auditchecklist.model.QuestionsEntity;
import com.prototype.auditchecklist.repository.ChecklistRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * This class contains test cases for the checklistService class which are
 * written using junit and mockito
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration
@Slf4j
public class ChecklistServiceTest {

	@Mock
	ChecklistRepository questionsRespository;

	@InjectMocks
	checklistService questionsService;

	/**
	 * test to check whether it returns a list
	 * 
	 * @throws IndexOutOfBoundsException
	 */
	@Test
	public void testGetQuestionsList() throws IndexOutOfBoundsException {
		log.info("start");
		List<QuestionsEntity> questions = new ArrayList<>();
		questions.add(
				new QuestionsEntity(1, "Internal", "Have all Change requests followed SDLC before PROD move?", "Yes"));
		when(questionsRespository.findByAuditType("Internal")).thenReturn(questions);
		assertEquals(questions, questionsService.getQuestions("Internal"));
		log.info("end");
	}

	/**
	 * test questions when list throws IndexOutOfBoundsException
	 */
	@Test
	public void testQuestionsListthrowsIndexOutOfBoundsException() {
		log.info("start");
		when(questionsRespository.findByAuditType("Internal")).thenThrow(IndexOutOfBoundsException.class);
		assertThrows(IndexOutOfBoundsException.class, () -> questionsService.getQuestions("Internal"));
		log.info("end");
	}

	@Test
	public void testSaveResponses() {
		log.info("start");
		List<QuestionsEntity> questions = new ArrayList<>();
		questions.add(
				new QuestionsEntity(1, "Internal", "Have all Change requests followed SDLC before PROD move?", "Yes"));
		when(questionsRespository.saveAll(questions)).thenReturn(questions);
		assertEquals(questions, questionsService.saveResponse(questions));
		log.info("end");
	}
}
