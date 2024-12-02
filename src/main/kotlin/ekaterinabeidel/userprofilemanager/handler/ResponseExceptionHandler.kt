package ekaterinabeidel.userprofilemanager.handler

import ekaterinabeidel.userprofilemanager.exception.IdNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ResponseExceptionHandler {
    @ExceptionHandler(IdNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleIdNotFoundException(e: IdNotFoundException): ResponseEntity<AppError> {
        val error = AppError(
            statusCode = HttpStatus.NOT_FOUND,
            message = e.message ?: "ID not found"
        )
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }
}