package com.rochards.productcatalogmanagement.controllers

import com.rochards.productcatalogmanagement.domain.BusinessException
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.method.annotation.HandlerMethodValidationException

private val logger = KotlinLogging.logger { }

@ControllerAdvice
class APIExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val errors = ex.bindingResult.allErrors.map { error ->
            if (error is FieldError)
                "${error.field} - ${error.defaultMessage}"
            else
                error.defaultMessage ?: "validation failed"
        }
        val errorResponse = ErrorResponse(
            code = ErrorCode.INVALID_FIELD.code,
            message = errors.joinToString("; ")
        )
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(HandlerMethodValidationException::class)
    fun handleHandlerMethodValidationException(ex: HandlerMethodValidationException): ResponseEntity<ErrorResponse> {

        val errors = ex.allErrors.map { error ->
            "${error.codes?.let { it[1].removePrefix("Size.") }} - ${error.defaultMessage}"
        }
        val errorResponse = ErrorResponse(
            code = ErrorCode.INVALID_FIELD.code,
            message = errors.joinToString("; ")
        )

        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(ex: BusinessException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            code = ErrorCode.BUSINESS_VIOLATION.code,
            message = ex.message!!
        )
        return ResponseEntity(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY)
    }

    @ExceptionHandler(Exception::class)
    fun handleGeneralException(ex: Exception): ResponseEntity<ErrorResponse> {
        logger.error { "$ex" }

        val errorResponse = ErrorResponse(
            code = ErrorCode.UNKNOWN.code,
            message = "internal server error"
        )
        return ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}

data class ErrorResponse(
    val code: String,
    val message: String
)

enum class ErrorCode(val code: String) {
    INVALID_FIELD("invalid_field"),
    BUSINESS_VIOLATION("business_violation"),
    UNKNOWN("unknown");
}