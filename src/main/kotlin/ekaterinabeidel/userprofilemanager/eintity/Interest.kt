package ekaterinabeidel.userprofilemanager.eintity

import jakarta.persistence.*

@Entity
 class Interest(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String = "",

) {
    constructor() : this(
        id = null,
        title = "",
    )
}
