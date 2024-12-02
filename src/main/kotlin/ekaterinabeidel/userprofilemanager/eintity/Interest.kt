package ekaterinabeidel.userprofilemanager.eintity

import jakarta.persistence.*
import jakarta.validation.constraints.*

@Entity
 class Interest(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @field:NotBlank
    @field:Size(max = 30)
    var title: String = "",

    @ManyToOne
    @JoinColumn(name = "user_profile_id", nullable = false)
    var userProfile: UserProfile? = null
) {
    constructor() : this(
        id = null,
        title = "",
        userProfile = null
    )
}
