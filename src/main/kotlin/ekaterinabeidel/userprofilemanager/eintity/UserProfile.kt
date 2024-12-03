package ekaterinabeidel.userprofilemanager.eintity

import ekaterinabeidel.userprofilemanager.enums.ProfileVisibility
import jakarta.persistence.*

@Entity
 class UserProfile(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Version
    var version: Int = 0,
    var name: String = "",
    var surname: String = "",
    var jobTitle: String? = null,
    var phone: String = "",
    var address: String? = null,

    @OneToMany(mappedBy = "userProfile", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.EAGER)
    var interests: MutableList<Interest> = mutableListOf(),

    var profileLink: String? = null,
    var avatarUrl: String? = null,

    @Enumerated(EnumType.STRING)
    var visibility: ProfileVisibility = ProfileVisibility.PRIVATE
) {
    constructor() : this(
        id = null,
        version = 0,
        name = "",
        surname = "",
        jobTitle = null,
        phone = "",
        address = null,
        interests = mutableListOf(),
        profileLink = null,
        avatarUrl = null,
        visibility = ProfileVisibility.PRIVATE
    )
}


