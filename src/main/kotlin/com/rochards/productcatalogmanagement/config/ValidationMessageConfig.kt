package com.rochards.productcatalogmanagement.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource

@Configuration
class ValidationMessageConfig {
    @Bean
    fun messageSource(): ReloadableResourceBundleMessageSource {
        return ReloadableResourceBundleMessageSource().also {
            it.setBasename("classpath:validation-messages")
            it.setDefaultEncoding("UTF-8")
        }
    }
}