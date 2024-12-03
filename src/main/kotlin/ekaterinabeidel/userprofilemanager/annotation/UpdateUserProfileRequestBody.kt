package ekaterinabeidel.userprofilemanager.annotation

import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@io.swagger.v3.oas.annotations.parameters.RequestBody(
    description = "User profile data",
    content = [Content(
        mediaType = "application/json",
        examples = [ExampleObject(
            name = "Update Profile Example",
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
    )]
)
annotation class UpdateUserProfileRequestBody()
