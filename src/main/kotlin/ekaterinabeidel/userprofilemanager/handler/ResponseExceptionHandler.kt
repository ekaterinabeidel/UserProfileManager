package ekaterinabeidel.userprofilemanager.handler

import ekaterinabeidel.userprofilemanager.exception.*
import jakarta.persistence.OptimisticLockException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
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

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleIllegalArgumentException(e: IllegalArgumentException): ResponseEntity<AppError> {
        val error = AppError(
            statusCode = HttpStatus.BAD_REQUEST,
            message = e.message ?: "Invalid input"
        )
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(FileEmptyException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleFileEmptyException(ex: FileEmptyException): ResponseEntity<AppError> {
        val error = AppError(
            statusCode = HttpStatus.BAD_REQUEST,
            message = ex.message ?: "File is empty."
        )
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(FileSizeExceededException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleFileSizeExceededException(ex: FileSizeExceededException): ResponseEntity<AppError> {
        val error = AppError(
            statusCode = HttpStatus.BAD_REQUEST,
            message = ex.message ?: "File size exceeds limit."
        )
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(InvalidFileFormatException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleInvalidFileFormatException(ex: InvalidFileFormatException): ResponseEntity<AppError> {
        val error = AppError(
            statusCode = HttpStatus.BAD_REQUEST,
            message = ex.message ?: "Invalid file format."
        )
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(FileStorageException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleFileStorageException(ex: FileStorageException): ResponseEntity<AppError> {
        val error = AppError(
            statusCode = HttpStatus.BAD_REQUEST,
            message = ex.message ?: "File storage error occurred."
        )
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationException(ex: MethodArgumentNotValidException): ResponseEntity<AppError> {
        val validationMessages = ex.bindingResult.fieldErrors.joinToString(", ") {
            "${it.field}: ${it.defaultMessage ?: "Invalid value"}"
        }

        val error = AppError(
            statusCode = HttpStatus.BAD_REQUEST,
            message = "Validation failed: $validationMessages"
        )

        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(OptimisticLockException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun handleOptimisticLockException(ex: OptimisticLockException): ResponseEntity<AppError> {
        val error = AppError(
            statusCode = HttpStatus.CONFLICT,
            message = "The record was updated by another transaction. Please reload and try again."
        )
        return ResponseEntity(error, HttpStatus.CONFLICT)
    }
}