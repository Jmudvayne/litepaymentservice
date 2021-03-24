/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.entrypoint.domain.exception;

import com.newstartup.litepaymentservice.application.entrypoint.domain.model.ApiError;
import com.newstartup.litepaymentservice.application.entrypoint.domain.model.ApiSubError;
import com.newstartup.litepaymentservice.application.entrypoint.domain.model.mapper.ApiSubErrorMapper;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * A Generic Exception Handler in charge of manage all the generic exceptions
 * that could happen into the entry points layer
 *
 * * @since 1.0.0
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestExceptionsHandler extends ResponseEntityExceptionHandler {

	// -----------------------------------------------------------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------------------------------------------------------

	/**
	 * Handle a {@link BadRequestException} by returning a proper {@link ResponseEntity}
	 * with an {@link ApiError} into its body
	 *
	 * @param exception a {@link BadRequestException} instance
	 * @return a {@link ResponseEntity} instance
	 */
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ApiError> handleBadRequestException(BadRequestException exception) {
		return ResponseEntity.status(400).body(buildBadRequestError(exception.getMessage(), null));
	}

	/**
	 * Handle a {@link ConstraintViolationException} by returning a proper {@link ResponseEntity}
	 * with an {@link ApiError} into its body
	 *
	 * @param exception a {@link ConstraintViolationException} instance
	 * @return a {@link ResponseEntity} instance
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ApiError> handleConstraintValidationException(ConstraintViolationException exception) {

		var subErrors = getConstraintViolationSubErrors(exception);
		var responseBody = buildBadRequestError("Constraint errors", subErrors);
		return ResponseEntity.status(400).body(responseBody);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException exception,
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request) {

		var fieldErrors = exception.getBindingResult().getFieldErrors();
		var errors = fieldErrors.stream().map(ApiSubErrorMapper::map).collect(Collectors.toList());
		var body = buildBadRequestError("Invalid request", errors);
		return super.handleExceptionInternal(exception, body, headers, status, request);
	}

	// -----------------------------------------------------------------------------------------------------------------
	// Inner logic
	// -----------------------------------------------------------------------------------------------------------------

	/**
	 * Builds an {@link ApiError} instance depending on the given parameters
	 *
	 * @param message   the error message
	 * @param subErrors a collection of sub errors
	 * @return an {@link ApiError} instance
	 */
	private ApiError buildBadRequestError(String message, Collection<ApiSubError> subErrors) {

		return ApiError.builder()
					   .timestamp(LocalDateTime.now())
					   .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
					   .message(message)
					   .subErrors(subErrors)
					   .build();
	}

	/**
	 * Given a {@link ConstraintViolationException}, the method returns all its related sub errors
	 *
	 * @param exception the {@link ConstraintViolationException} for which the sub-errors will be built
	 * @return a {@link Collection<ApiSubError>}
	 */
	private Collection<ApiSubError> getConstraintViolationSubErrors(ConstraintViolationException exception) {

		return exception.getConstraintViolations().stream()
						.map(violation -> new ApiSubError(
								violation.getMessage(),
								violation.getInvalidValue(),
								violation.getPropertyPath().toString()))
						.collect(Collectors.toList());
	}
}
