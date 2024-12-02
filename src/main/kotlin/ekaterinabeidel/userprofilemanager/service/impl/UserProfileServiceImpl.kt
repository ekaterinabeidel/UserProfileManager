package ekaterinabeidel.userprofilemanager.service.impl

import ekaterinabeidel.userprofilemanager.dto.UpdateUserProfileDto
import ekaterinabeidel.userprofilemanager.dto.UserProfileDto
import ekaterinabeidel.userprofilemanager.exception.IdNotFoundException
import ekaterinabeidel.userprofilemanager.repository.UserProfileRepository
import ekaterinabeidel.userprofilemanager.service.UserProfileService
import org.springframework.stereotype.Service
import util.Mapper

@Service
class UserProfileServiceImpl (
    private val userProfileRepository: UserProfileRepository
) : UserProfileService {
    override fun getUserProfile(userId: Long): UserProfileDto {
        val userProfile = userProfileRepository.findById(userId)
            .orElseThrow { IdNotFoundException("User profile not found for id: $userId") }
        return Mapper.convertEntityToUserProfileDto(userProfile)
    }

    override fun updateUserProfile(userId: Long, updateUserProfileDto: UpdateUserProfileDto): UserProfileDto {
        val userProfile = userProfileRepository.findById(userId)
            .orElseThrow { IllegalArgumentException("User profile not found for id: $userId") }
        Mapper.convertUpdateUserProfileDtoToEntity(updateUserProfileDto, userProfile)
        userProfileRepository.save(userProfile)

        return Mapper.convertEntityToUserProfileDto(userProfile)
    }
}