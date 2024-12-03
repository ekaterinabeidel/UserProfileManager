package ekaterinabeidel.userprofilemanager.configuration

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("User Profile Manager API")
                    .description("API documentation for User Profile Manager")
                    .version("1.0.0")
                    .license(
                        License()
                            .name("Apache 2.0")
                            .url("http://springdoc.org")
                    )
            )
            .externalDocs(
                ExternalDocumentation()
                    .description("Project Repository")
                    .url("https://github.com/ekaterinabeidel/UserProfileManager")
            )
    }
}