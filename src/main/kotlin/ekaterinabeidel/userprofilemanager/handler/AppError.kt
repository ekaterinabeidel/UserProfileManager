package ekaterinabeidel.userprofilemanager.handler

import org.springframework.http.HttpStatus

data class AppError(
    val statusCode: HttpStatus,
    val message: String
)
