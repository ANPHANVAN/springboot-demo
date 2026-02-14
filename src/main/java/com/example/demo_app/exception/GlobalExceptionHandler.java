package com.example.demo_app.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex) {

		log.error("Hệ thống xảy ra lỗi nghiêm trọng: {}", ex.getMessage(), ex);

		ErrorResponse error = new ErrorResponse(
			HttpStatus.INTERNAL_SERVER_ERROR.value(),
			"Hệ thống đang gặp sự cố, vui lòng thử lại sau!",
			"INTERNAL_SERVER_ERROR",
			LocalDateTime.now()
		);

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}