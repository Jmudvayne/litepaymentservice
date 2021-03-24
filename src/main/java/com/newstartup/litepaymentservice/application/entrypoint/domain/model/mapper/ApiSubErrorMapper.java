/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.entrypoint.domain.model.mapper;

import com.newstartup.litepaymentservice.application.entrypoint.domain.model.ApiSubError;
import org.springframework.validation.FieldError;

/**
 * Utility made with the goal to perform conversions between {@link FieldError} and {@link ApiSubError}
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
public class ApiSubErrorMapper {

	// -----------------------------------------------------------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------------------------------------------------------

	/**
	 * Private constructor made in order to prevent mapper instantiation
	 */
	private ApiSubErrorMapper() {
		// Empty constructor
	}

	// -----------------------------------------------------------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------------------------------------------------------

	/**
	 * Receives a {@link FieldError} and returns its equivalent {@link ApiSubError}
	 *
	 * @param fieldError a {@link FieldError} instance
	 * @return a {@link ApiSubError} instance
	 */
	public static ApiSubError map(FieldError fieldError) {

		return ApiSubError
				.builder()
				.field(fieldError.getField())
				.message(fieldError.getDefaultMessage())
				.rejectedValue(fieldError.getRejectedValue())
				.build();
	}
}
