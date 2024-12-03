package ekaterinabeidel.userprofilemanager.annotation

import io.swagger.v3.oas.annotations.tags.Tag

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Tag(
    name = "User Profile Controller",
    description = "APIs for managing user profiles, including retrieval, update, and avatar upload."
)
annotation class UserProfileControllerTag()
