package ekaterinabeidel.userprofilemanager.service

import ekaterinabeidel.userprofilemanager.dto.UserProfileDto
import org.springframework.stereotype.Service

@Service
interface UserProfileService {
    fun getUserProfile(userId: Long): UserProfileDto
}