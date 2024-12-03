package ekaterinabeidel.userprofilemanager.controller

import ekaterinabeidel.userprofilemanager.dto.UpdateUserProfileDto
import ekaterinabeidel.userprofilemanager.dto.UserProfileDto
import ekaterinabeidel.userprofilemanager.service.UserProfileService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api")
@Tag(name = "User Profile Controller",
    description = "APIs for managing user profiles, including retrieval, update, and avatar upload.")
class UserProfileController(
    private val userProfileService: UserProfileService) {

    @Operation(summary = "Get user profile by ID", description = "Retrieve the profile of a user using their ID")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successfully retrieved user profile"),
            ApiResponse(responseCode = "404", description = "User not found", content = [Content()]),
        ]
    )
    @GetMapping("/profile")
    fun getUserProfile(@RequestParam userId: Long): ResponseEntity<UserProfileDto> {
        return ResponseEntity.ok(userProfileService.getUserProfile(userId))
    }

    @Operation(summary = "Update user profile", description = "Update the profile details of a user")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Profile updated successfully",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = UserProfileDto::class))]),
            ApiResponse(responseCode = "400", description = "Invalid input data",
                content = [Content(mediaType = "application/json")]),
            ApiResponse(responseCode = "404", description = "User profile not found",
                content = [Content(mediaType = "application/json")])
        ]
    )
    @PutMapping("/profile")
    fun updateUserProfile(@RequestParam userId: Long,
                          @RequestBody updateUserProfileDto: UpdateUserProfileDto
    ): ResponseEntity<UserProfileDto> {
        val updatedProfile = userProfileService.updateUserProfile(userId, updateUserProfileDto)
        return ResponseEntity.ok(updatedProfile)
    }

    @Operation(summary = "Upload user avatar", description = "Upload and save a new avatar for the user")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Avatar uploaded successfully",
                content = [Content(mediaType = "application/json")]),
            ApiResponse(responseCode = "400", description = "Invalid file input",
                content = [Content(mediaType = "application/json")])
        ]
    )
    @PostMapping("/upload-avatar", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun uploadAvatar(@RequestParam userId: Long,
                     @RequestPart file: MultipartFile
    ): ResponseEntity<Map<String, String>>{
        val avatarUrl = userProfileService.uploadAvatar(userId, file)
        return ResponseEntity.ok(mapOf("URL" to avatarUrl))
    }
}