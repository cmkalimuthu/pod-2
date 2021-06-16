package com.prototype.auditwebportal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prototype.auditwebportal.feignclients.AuditCheckListProxy;
import com.prototype.auditwebportal.feignclients.AuditSeverityProxy;
import com.prototype.auditwebportal.feignclients.AuthClient;
import com.prototype.auditwebportal.model.AuditDetails;
import com.prototype.auditwebportal.model.AuditRequest;
import com.prototype.auditwebportal.model.AuditResponse;
import com.prototype.auditwebportal.model.AuditType;
import com.prototype.auditwebportal.model.ProjectDetails;
import com.prototype.auditwebportal.model.ProjectManager;
import com.prototype.auditwebportal.model.Questions;
import com.prototype.auditwebportal.model.QuestionsEntity;
import com.prototype.auditwebportal.model.User;

@Controller
public class WebPortalController {

	// This class is handling all the end points for Audit Checklist, Audit
	// Authentication and Audit Severity microservice.

	// AuthClient is used to verify the token.
	// AuditCheckListProxy is to call methods from other AuditCheckList
	// microservice.
	// AuditSeverityProxy is to call methods from other AuditSeverity microservice.

	@Autowired
	AuthClient authClient;

	@Autowired
	AuditRequest auditRequest;

	@Autowired
	AuditCheckListProxy auditCheckListProxy;

	@Autowired
	AuditSeverityProxy auditSeverityProxy;

	/*
	 * This is method which returns login page
	 */
	@GetMapping("/login-page")
	public String loginPage(@ModelAttribute User user) {

		return "login";
	}

//	@GetMapping("/home")
//	public String home() {
//		return "forbidden";
//	}
//	
	/*
	 * This method returns a form to fill details for type of Audit to do and other
	 * project details.
	 */
	@PostMapping("/home")
	public String getHome(@ModelAttribute("user") User userCredentials, HttpServletRequest request, ModelMap map) {
		System.out.println(userCredentials.getUserId() + " " + userCredentials.getPassword());
		ResponseEntity<ProjectManager> token = null;
		ProjectManager projectManager = null;
		map.addAttribute("auditType", new AuditType());
		map.addAttribute("projectDetails", new ProjectDetails());

		try {
			token = (ResponseEntity<ProjectManager>) authClient.login(userCredentials);
			projectManager = token.getBody();
			request.getSession().setAttribute("token", "Bearer " + projectManager.getAuthToken());
			return "home";
		} catch (Exception e) {
			return "error-login";
		}
	}

	/*
	 * This method gets audit checklist from auditChecklist microservice and
	 * redirects to questions
	 */
	@PostMapping("/AuditCheckListQuestions")
	public String getResponses(@ModelAttribute("projectDetails") ProjectDetails projectDetails,
			@ModelAttribute("auditType") AuditType auditType, RedirectAttributes redirectAttributes,
			HttpSession request, ModelMap map) {
		List<QuestionsEntity> questions = new ArrayList<>();
		auditRequest.setProjectName(projectDetails.getProjectName());
		auditRequest.setManagerName(projectDetails.getManagerName());
		auditRequest.setOwnerName(projectDetails.getOwnerName());
		try {
			System.out.println("audit type" + auditType);
			questions = auditCheckListProxy.getQuestions(request.getAttribute("token").toString(), auditType).getBody();
			System.out.println(questions);

		} catch (IndexOutOfBoundsException e) {
			if (e.getMessage().contains("invalid audit type")) {
				return "redirect:/internalServerError";
			}

		} catch (Exception e) {

			if (e.getMessage().contains("Access Denied"))
				return "tokenExpiredPage";

			return "internalServerError";

		}

		for (QuestionsEntity question : questions) {
			System.out.println("questions " + question);
			if (question.getResponse() != null) {
				question.setResponse(null);
			}

		}
		Questions questionslist = new Questions();
		questionslist.setQuestionsEntity(questions);
		System.out.println(questionslist.getQuestionsEntity());
		redirectAttributes.addFlashAttribute("questions", questionslist);
		redirectAttributes.addFlashAttribute("auditType", auditType);
		return "redirect:/questions";

	}

	/*
	 * This methods returns the questions page
	 */
	@GetMapping("/questions")
	public String getQuestions(@ModelAttribute("questions") Questions questions,
			@ModelAttribute("auditType") AuditType auditType, HttpSession session, ModelMap map) {
		ResponseEntity<?> authResponse = null;
		try {

			authResponse = authClient.getValidity(session.getAttribute("token").toString());

		} catch (Exception e) {
			if (e.getMessage().contains("the token is expired and not valid anymore"))
				return "tokenExpiredPage";

			return "forbidden";
		}
		if (authResponse == null) {
			return "internalServerError";

		}
		return "questions";

	}

	/*
	 * redirects to status page
	 */
	@PostMapping("/questions")
	public String getResponses(@ModelAttribute("questions") Questions questions, HttpSession session) {
		ResponseEntity<?> authResponse = null;
		List<QuestionsEntity> responseEntity = null;
		List<QuestionsEntity> questionsEntity = questions.getQuestionsEntity();
		try {
			authResponse = authClient.getValidity(session.getAttribute("token").toString());
			System.out.println("after submission " + questionsEntity);
			responseEntity = auditCheckListProxy
					.saveResponses(session.getAttribute("token").toString(), questionsEntity).getBody();

		} catch (Exception e) {
			if (e.getMessage().contains("Access Denied"))
				return "tokenExpiredPage";
			if (e.getMessage().contains("Authentication Failed. Username or Password not valid."))
				return "authFailed";
			if (authResponse == null || responseEntity == null) {
				return "internalServerError";

			}

			return "forbidden";
		}
		AuditDetails auditDetails = new AuditDetails(questions.getQuestionsEntity().get(0).getAuditType(), new Date());
		auditRequest.setAuditDetails(auditDetails);
		return "redirect:/status";
	}

	/*
	 * return status page
	 */
	@GetMapping("/status")
	public String getProjectExecutionStatus(HttpSession request, ModelMap map) {
		AuditResponse auditResponse = null;
		try {
			auditResponse = auditSeverityProxy.auditSeverity(request.getAttribute("token").toString(), auditRequest)
					.getBody();

		} catch (Exception e) {
			if (e.getMessage().contains("the token is expired and not valid anymore"))
				return "tokenExpiredPage";
			else if (e.getMessage().contains("Access Denied"))
				return "forbidden";

			return "internalServerError";
		}
		map.addAttribute("auditResponse", auditResponse);
		return "status";

	}

	/*
	 * return internal server error page when user when 405 occurs
	 */
	@GetMapping("/internalServerError")
	public String internalError(HttpServletRequest request) {
		request.getSession().invalidate();
		return "internalServerError";

	}

	/*
	 * return login page when user log outs of the session
	 */

	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		request.getSession().setAttribute("token", null);
		response.setHeader("Cache-Control", "no-cache"); // Forces caches to obtain a new copy of the page from the
															// origin server
		response.setHeader("Cache-Control", "no-store"); // Directs caches not to store the page under any circumstance
		response.setDateHeader("Expires", 0); // Causes the proxy cache to see the page as "stale"
		response.setHeader("Pragma", "no-cache");

		return "redirect:/login-page";
	}

}
