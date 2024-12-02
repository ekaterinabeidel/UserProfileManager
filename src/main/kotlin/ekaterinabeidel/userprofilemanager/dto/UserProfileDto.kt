package ekaterinabeidel.userprofilemanager.dto

import ekaterinabeidel.userprofilemanager.enums.ProfileVisibility
import jakarta.validation.constraints.NotNull

data class UserProfileDto(
    val name: String,
    val surname: String,
    val jobTitle: String?,
    val phone: String,
    val address: String?,
    val interests: List<String>,
    val avatarUrl: String,
    @field:NotNull(message = "Profile visibility must be specified.")
    val visibility: ProfileVisibility = ProfileVisibility.PRIVATE,
)
