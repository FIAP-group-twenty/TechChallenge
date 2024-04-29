package br.group.twenty.challenge.config

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders

@Configuration
class OpenApiConfig {
    @Bean
    fun customOpenAPI(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("apiv1")
            .pathsToMatch("/apiv1/**")
            .build()
    }

    @Bean
    fun httpHeaders(): HttpHeaders {
        val headers = HttpHeaders()
        headers.add("X-Custom-Header", "Custom Value")
        return headers
    }
}