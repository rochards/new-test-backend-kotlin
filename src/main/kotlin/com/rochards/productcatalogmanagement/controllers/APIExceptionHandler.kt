package com.rochards.productcatalogmanagement.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

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
}

data class ErrorResponse(
    val code: String,
    val message: String
)

enum class ErrorCode(val code: String) {
    INVALID_FIELD("invalid_field"),
    UNKNOWN("unknown")
}