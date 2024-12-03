package ekaterinabeidel.userprofilemanager.controller

import ekaterinabeidel.userprofilemanager.annotation.*
import ekaterinabeidel.userprofilemanager.dto.UpdateUserProfileDto
import ekaterinabeidel.userprofilemanager.dto.UserProfileDto
import ekaterinabeidel.userprofilemanager.service.UserProfileService
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@Validated
@RestController
@RequestMapping("/api")
@UserProfileControllerTag
class UserProfileController(
    private val userProfileService: UserProfileService
) {

    @GetUserProfile
    @GetMapping("/profile")
    fun getUserProfile(@RequestParam userId: Long): ResponseEntity<UserProfileDto> {
        return ResponseEntity.ok(userProfileService.getUserProfile(userId))
    }

    @UpdateUserProfile
    @PutMapping("/profile")
    fun updateUserProfile(
        @RequestParam userId: Long,
        @Valid @RequestBody updateUserProfileDto: UpdateUserProfileDto
    ): ResponseEntity<UserProfileDto> {
        val updatedProfile = userProfileService.updateUserProfile(userId, updateUserProfileDto)
        return ResponseEntity.ok(updatedProfile)
    }

    @UploadAvatar
    @PostMapping("/upload-avatar", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun uploadAvatar(
        @RequestParam userId: Long,
        @RequestPart file: MultipartFile
    ): ResponseEntity<Map<String, String>> {
        val avatarUrl = userProfileService.uploadAvatar(userId, file)
        return ResponseEntity.ok(mapOf("URL" to avatarUrl))
    }
}