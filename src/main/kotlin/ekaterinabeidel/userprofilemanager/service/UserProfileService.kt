package ekaterinabeidel.userprofilemanager.service

import ekaterinabeidel.userprofilemanager.dto.UpdateUserProfileDto
import ekaterinabeidel.userprofilemanager.dto.UserProfileDto
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
interface UserProfileService {
    fun getUserProfile(userId: Long): UserProfileDto
    fun updateUserProfile(userId: Long, updateUserProfileDto: UpdateUserProfileDto): UserProfileDto
    fun uploadAvatar(userId: Long, file: MultipartFile): String
}