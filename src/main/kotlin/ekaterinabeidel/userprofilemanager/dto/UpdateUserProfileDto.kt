package ekaterinabeidel.userprofilemanager.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class UpdateUserProfileDto(
    @field:NotBlank
    @field:Size(min = 2, max = 50)
    @field:Pattern(
        regexp = "^[\\p{L}\\s\\-]+$",
        message = "Name can only contain letters, spaces, and hyphens."
    )
    val name: String,

    @field:NotBlank
    @field:Size(min = 2, max = 50)
    @field:Pattern(
        regexp = "^\\p{L}(?:[\\p{L}\\s\\-]*\\p{L})?\$\n",
        message = "Surname can only contain letters, spaces, and hyphens."
    )
    val surname: String,

    @field:Size(max = 100)
    val jobTitle: String?,

    @field:NotBlank
    @field:Size(min = 10, max = 15)
    @field:Pattern(regexp = "^\\+[1-9][0-9]{9,14}$",
        message = "Phone number must start with '+' followed by a valid country code and digits.")
    val phone: String,

    @field:Size(max = 200)
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

    val isPublic: Boolean
)
