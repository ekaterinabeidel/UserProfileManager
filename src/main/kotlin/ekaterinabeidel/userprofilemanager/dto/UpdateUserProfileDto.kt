package ekaterinabeidel.userprofilemanager.dto

import ekaterinabeidel.userprofilemanager.enums.ProfileVisibility
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class UpdateUserProfileDto(
    @field:NotBlank(message = "Name is required.")
    @field:Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters.")
    @field:Pattern(
        regexp = "^[\\p{L}\\s\\-]+$",
        message = "Name can only contain letters, spaces, and hyphens."
    )
    val name: String,

    @field:NotBlank(message = "Surname is required.")
    @field:Size(min = 2, max = 50, message = "Surname must be between 2 and 50 characters.")
    @field:Pattern(
        regexp = "^\\p{L}[\\p{L}\\s\\-']*\\p{L}\$",
        message = "Surname can only contain letters, spaces, and hyphens."
    )
    val surname: String,

    @field:Size(max = 100, message = "Job Title must be at most 100 characters long.")
    @field:Pattern(
        regexp = "^[\\p{L}\\p{N} ]*\$",
        message = "Job Title can only contain letters, numbers, and spaces."
    )
    val jobTitle: String?,

    @field:NotBlank(message = "Phone number is required.")
    @field:Size(min = 10, max = 15, message = "Phone must be between 10 and 15 characters.")
    @field:Pattern(
        regexp = "^\\+[1-9][0-9]{9,14}$",
        message = "Phone number must start with '+' followed by a valid country code and digits."
    )
    val phone: String,

    @field:Size(max = 200, message = "Address must be at most 200 characters long.")
    @field:Pattern(
        regexp = "^[\\p{L}\\p{N},.\\-\\s]*$",
        message = "Address can only contain letters, numbers, commas, dots, hyphens, and spaces."
    )
    val address: String?,

    @field:Size(max = 10, message = "You can specify up to 10 interests.")
    val interests: List<@Size(max = 30, message = "Each interest must be at most 30 characters long.")
    @Pattern(
        regexp = "^[\\p{L}\\p{N},.\\s]+$",
        message = "Interest can only contain letters, numbers, commas, dots, and spaces."
    ) String>,

    @field:Size(max = 200, message = "Link must be at most 200 characters long.")
    @field:Pattern(
        regexp = "^(http://|https://)\\S+$",
        message = "Link must be a valid URL starting with 'http://' or 'https://'."
    )
    val profileLink: String? = null,

    @field:NotNull(message = "Profile visibility must be specified.")
    val visibility: ProfileVisibility = ProfileVisibility.PRIVATE
)
