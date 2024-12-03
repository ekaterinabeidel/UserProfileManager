package ekaterinabeidel.userprofilemanager.annotation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Operation(
    summary = "Update user profile",
    description = "Update the profile details of a user",
    responses = [
        ApiResponse(
            description = "Successfully retrieved user profile",
            responseCode = "200",
            content = [
                Content(
                    mediaType = "application/json",
                    examples = [ExampleObject(
                        name = "Example User Profile",
                        value = """
                              {
                          "name": "Albert",
                          "surname": "Einstein",
                          "jobTitle": "Theoretical Physicist",
                          "phone": "+79991234567",
                          "address": "Princeton",
                          "interests": ["Relativity", "Quantum Mechanics"],
                          "profileLink": "https://example.com/profiles/einstein",
                          "visibility": "PUBLIC"
                        }
                            """
                    )]
                )
            ]
        )
    ]
)
@ApiResponses(
    value = [
        ApiResponse(responseCode = "200", description = "Profile updated successfully"),
        ApiResponse(
            responseCode = "400", description = "Invalid input data",
            content = [Content(mediaType = "application/json")]
        ),
        ApiResponse(
            responseCode = "404", description = "User profile not found",
            content = [Content(mediaType = "application/json")]
        )
    ]
)
annotation class UpdateUserProfile()
