package ekaterinabeidel.userprofilemanager.service.impl

import ekaterinabeidel.userprofilemanager.dto.UpdateUserProfileDto
import ekaterinabeidel.userprofilemanager.dto.UserProfileDto
import ekaterinabeidel.userprofilemanager.exception.*
import ekaterinabeidel.userprofilemanager.repository.UserProfileRepository
import ekaterinabeidel.userprofilemanager.service.UserProfileService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import ekaterinabeidel.userprofilemanager.util.Mapper
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.*

@Service
class UserProfileServiceImpl(
    private val userProfileRepository: UserProfileRepository,
    @Value("\${file.upload-dir}") private val uploadDir: String
) : UserProfileService {
    override fun getUserProfile(userId: Long): UserProfileDto {
        val userProfile = userProfileRepository.findById(userId)
            .orElseThrow { IdNotFoundException("User profile not found for id: $userId") }

        return Mapper.convertEntityToUserProfileDto(userProfile)
    }

    override fun updateUserProfile(userId: Long, updateUserProfileDto: UpdateUserProfileDto): UserProfileDto {
        val userProfile = userProfileRepository.findById(userId)
            .orElseThrow { IdNotFoundException("User profile not found for id: $userId") }

        val uniqueInterests = updateUserProfileDto.interests.distinct()
        Mapper.convertUpdateUserProfileDtoToEntity(
            updateUserProfileDto.copy(interests = uniqueInterests),
            userProfile
        )
        userProfileRepository.save(userProfile)

        return Mapper.convertEntityToUserProfileDto(userProfile)
    }

    override fun uploadAvatar(userId: Long, file: MultipartFile): String {
        if (file.isEmpty) {
            throw FileEmptyException("File is empty.")
        }
        if (file.size > 5 * 1024 * 1024) {
            throw FileSizeExceededException("File size exceeds 5 MB")
        }

        val allowedExtensions = listOf("jpg", "jpeg", "png")
        val fileExtension = file.originalFilename?.substringAfterLast('.')?.lowercase(Locale.getDefault())
            ?: throw InvalidFileFormatException("Invalid file format")
        if (fileExtension !in allowedExtensions) {
            throw InvalidFileFormatException("Invalid file format. Only .jpg, .jpeg, .png are allowed.")
        }

        val userProfile = userProfileRepository.findById(userId)
            .orElseThrow { IdNotFoundException("User profile not found for id: $userId") }

        synchronized(this) {
            val uploadPath: Path = Paths.get(uploadDir)
            runCatching {
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath)
                }
            }.getOrElse { e ->
                throw FileStorageException("Failed to create upload directory: $uploadDir", e)
            }


            val fileName = "${UUID.randomUUID()}.$fileExtension"
            val targetPath = uploadPath.resolve(fileName)
            runCatching {
                file.inputStream.use { input ->
                    Files.copy(input, targetPath, StandardCopyOption.REPLACE_EXISTING)
                }
            }.getOrElse { e ->
                throw FileStorageException("Failed to save file: $fileName", e)
            }

            val avatarUrl = "/uploads/avatars/$fileName"
            userProfile.avatarUrl = avatarUrl
            userProfileRepository.save(userProfile)

            return avatarUrl
        }
    }
}