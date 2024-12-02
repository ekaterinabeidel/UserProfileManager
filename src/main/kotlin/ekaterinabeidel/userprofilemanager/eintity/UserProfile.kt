package ekaterinabeidel.userprofilemanager.eintity

import ekaterinabeidel.userprofilemanager.enums.ProfileVisibility
import jakarta.persistence.*
import jakarta.validation.constraints.*

@Entity
 class UserProfile(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @field:NotBlank
    @field:Size(min = 2, max = 50)
    var name: String = "",

    @field:NotBlank
    @field:Size(min = 2, max = 50)
    var surname: String = "",

    @field:Size(max = 100)
    var jobTitle: String? = null,

    @field:NotBlank
    @field:Pattern(regexp = "^\\+[1-9][0-9]{9,14}$", message = "Invalid phone number format.")
    var phone: String = "",

    @field:Size(max = 200)
    var address: String? = null,

    @OneToMany(mappedBy = "userProfile", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.EAGER)
    var interests: MutableList<Interest> = mutableListOf(),

    @field:Size(max = 200)
    var avatarUrl: String? = null,

    @Enumerated(EnumType.STRING)
    var visibility: ProfileVisibility = ProfileVisibility.PRIVATE
) {
    constructor() : this(
        id = null,
        name = "",
        surname = "",
        jobTitle = null,
        phone = "",
        address = null,
        interests = mutableListOf(),
        avatarUrl = null,
        visibility = ProfileVisibility.PRIVATE
    )
}


