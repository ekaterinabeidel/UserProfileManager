package ekaterinabeidel.userprofilemanager.controller

import ekaterinabeidel.userprofilemanager.dto.UpdateUserProfileDto
import ekaterinabeidel.userprofilemanager.dto.UserProfileDto
import ekaterinabeidel.userprofilemanager.service.UserProfileService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class UserProfileController(private val userProfileService: UserProfileService) {

    @GetMapping("/profile")
    fun getUserProfile(@RequestParam userId: Long): ResponseEntity<UserProfileDto> {
        return ResponseEntity.ok(userProfileService.getUserProfile(userId))
    }

    @PutMapping("/profile")
    fun updateUserProfile(@RequestParam userId: Long,
                          @RequestBody updateUserProfileDto: UpdateUserProfileDto
    ): ResponseEntity<UserProfileDto> {
        val updatedProfile = userProfileService.updateUserProfile(userId, updateUserProfileDto)
        return ResponseEntity.ok(updatedProfile)
    }
}