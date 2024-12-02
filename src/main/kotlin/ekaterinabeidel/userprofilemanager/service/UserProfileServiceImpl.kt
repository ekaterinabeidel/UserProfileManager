package ekaterinabeidel.userprofilemanager.service

import ekaterinabeidel.userprofilemanager.dto.UserProfileDto
import ekaterinabeidel.userprofilemanager.exception.IdNotFoundException
import ekaterinabeidel.userprofilemanager.repository.UserProfileRepository
import org.springframework.stereotype.Service
import util.Mapper

@Service
class UserProfileServiceImpl (
    private val userProfileRepository: UserProfileRepository
) : UserProfileService{
    override fun getUserProfile(userId: Long): UserProfileDto {
        val userProfile = userProfileRepository.findById(userId)
            .orElseThrow { IdNotFoundException("User profile not found") }
        return Mapper.convertEntityToUserProfileDto(userProfile)
    }
}