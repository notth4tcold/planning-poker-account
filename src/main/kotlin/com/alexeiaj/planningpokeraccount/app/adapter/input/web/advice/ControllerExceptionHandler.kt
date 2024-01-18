package com.alexeiaj.planningpokeraccount.app.adapter.input.web.advice

import com.alexeiaj.planningpokeraccount.core.common.exception.AccountNotFoundException
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class ControllerExceptionHandler {

    @ExceptionHandler(value = [AccountNotFoundException::class])
    @ResponseStatus(value = NOT_FOUND)
    fun resourceNotFoundException(ex: Exception): ResponseEntity<ErrorMessageModel> {

        val errorMessage = ErrorMessageModel(
                NOT_FOUND.value(),
                ex.message
        )

        return ResponseEntity(errorMessage, BAD_REQUEST)
    }

}

class ErrorMessageModel(
        var status: Int? = null,
        var message: String? = null
)