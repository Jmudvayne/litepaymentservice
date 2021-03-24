/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.entrypoint.domain.exception;

/**
 * An exception created with the goal to indicate that the incoming request
 * has form errors like model validation or constraints breaches
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
public class BadRequestException extends Exception {

	/**
	 * Builds the exception by requesting the message that will be inside
	 * the exception
	 *
	 * @param message a message with the exception explanation
	 */
	public BadRequestException(String message) {

		super(message);
	}
}
