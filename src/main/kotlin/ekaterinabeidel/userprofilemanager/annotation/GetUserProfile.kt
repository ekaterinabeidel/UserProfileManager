package ekaterinabeidel.userprofilemanager.annotation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Operation(
    summary = "Get user profile by ID",
    description = "Retrieve the profile of a user using their ID",
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
                          "avatarUrl": "https://example.com/avatar1.jpg",
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
        ApiResponse(responseCode = "200", description = "Successfully retrieved user profile"),
        ApiResponse(responseCode = "404", description = "User not found", content = [Content()]),
    ]
)
annotation class GetUserProfile()
