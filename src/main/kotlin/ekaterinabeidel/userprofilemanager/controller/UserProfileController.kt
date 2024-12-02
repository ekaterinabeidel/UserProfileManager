package ekaterinabeidel.userprofilemanager.controller

import ekaterinabeidel.userprofilemanager.dto.UserProfileDto
import ekaterinabeidel.userprofilemanager.service.UserProfileService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserProfileController(private val userProfileService: UserProfileService) {

    @GetMapping("/profile")
    fun getUserProfile(@RequestParam userId: Long): UserProfileDto {
        return userProfileService.getUserProfile(userId)
    }
}