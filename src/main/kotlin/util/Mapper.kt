package util

import ekaterinabeidel.userprofilemanager.dto.UpdateUserProfileDto
import ekaterinabeidel.userprofilemanager.dto.UserProfileDto
import ekaterinabeidel.userprofilemanager.eintity.UserProfile

object Mapper {
    fun convertEntityToUserProfileDto(userProfile: UserProfile): UserProfileDto {
        return UserProfileDto(
            name = userProfile.name,
            surname = userProfile.surname,
            jobTitle = userProfile.jobTitle,
            phone = userProfile.phone,
            address = userProfile.address,
            interests = userProfile.interests.map { it.title },
            isPublic = userProfile.isPublic,
            avatarUrl = userProfile.avatarUrl ?: ""
        )
    }

    fun convertUpdateUserProfileDtoToEntity(
        updateUserProfileDto: UpdateUserProfileDto, userProfile: UserProfile): UserProfile {
        userProfile.name = updateUserProfileDto.name
        userProfile.surname = updateUserProfileDto.surname
        userProfile.jobTitle = updateUserProfileDto.jobTitle
        userProfile.phone = updateUserProfileDto.phone
        userProfile.isPublic = updateUserProfileDto.isPublic
        return userProfile
    }
}