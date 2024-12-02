package ekaterinabeidel.userprofilemanager.repository

import ekaterinabeidel.userprofilemanager.eintity.UserProfile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserProfileRepository : JpaRepository<UserProfile, Long>