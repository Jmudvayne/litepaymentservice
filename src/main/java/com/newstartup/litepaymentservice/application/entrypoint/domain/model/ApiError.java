/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.entrypoint.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * A model to be used into a response body if an error happens into the entry-points layer
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ApiError {

	/**
	 * The http status for the api error
	 */
	private String status;

	/**
	 * Time stamp in which the error happened
	 */
	private LocalDateTime timestamp;

	/**
	 * A human readable message with the error details
	 */
	private String message;

	/**
	 * Deeper details around the error
	 */
	private String debugMessage;

	/**
	 * If the api error is a summary of errors, the sub errors field
	 * represent all the error that happened at the same time that
	 * prevent a correct processing into the entry-points layer
	 */
	private Collection<ApiSubError> subErrors;

}
