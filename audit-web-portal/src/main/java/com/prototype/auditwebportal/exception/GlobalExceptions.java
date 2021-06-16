package com.prototype.auditwebportal.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * This class handles all the exceptions. Whenever an exception occurs
 * anywhere then first it will be checked whether there is {@link GlobalErrorHandler} 
 * declared or not. This has an annotation
 * RestControllerAdvice so it works for all controllers and classes.
 *          
 * @see ResponseEntityExceptionHandler
 *
 */
@ControllerAdvice
public class GlobalExceptions {

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ModelAndView handleError405(HttpServletRequest request, Exception e) {
		ModelAndView mav = new ModelAndView("/405");
		mav.addObject("exception", e);
		return mav;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView Error500(Exception ex, HttpServletRequest request) {
		ModelAndView mav1 = new ModelAndView("/internalServerError");
		mav1.addObject("exception", ex);
		if (ex instanceof NullPointerException) {
			return mav1;
		}
		return mav1;
	}
}
