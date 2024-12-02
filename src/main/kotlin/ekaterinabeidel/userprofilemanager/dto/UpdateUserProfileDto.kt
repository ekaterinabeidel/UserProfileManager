package ekaterinabeidel.userprofilemanager.dto

data class UpdateUserProfileDto(
    val name: String,
    val surname: String,
    val jobTitle: String?,
    val phone: String,
    val address: String?,
    val interests: List<String>,
    val isPublic: Boolean
)
