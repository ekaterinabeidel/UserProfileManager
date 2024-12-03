package ekaterinabeidel.userprofilemanager.annotation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Operation(summary = "Upload user avatar", description = "Upload and save a new avatar for the user")
@ApiResponses(
    value = [
        ApiResponse(
            responseCode = "200", description = "Avatar uploaded successfully",
            content = [Content(mediaType = "application/json")]
        ),
        ApiResponse(
            responseCode = "400", description = "Invalid file input",
            content = [Content(mediaType = "application/json")]
        )
    ]
)
annotation class UploadAvatar()
