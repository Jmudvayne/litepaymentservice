/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.entrypoint.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Model that represents in a deeper way why and how an {@link ApiError} is fired,
 * explaining in which field the error happened and the rejected value
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ApiSubError {

	/**
	 * The name of the field in which the error happened
	 */
	private String field;

	/**
	 * The filed value that fired the error
	 */
	private Object rejectedValue;

	/**
	 * A message saying why the field was rejected
	 */
	private String message;
}
