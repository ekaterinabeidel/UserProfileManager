package ekaterinabeidel.userprofilemanager.eintity

import jakarta.persistence.*

@Entity
 class Interest(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
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
