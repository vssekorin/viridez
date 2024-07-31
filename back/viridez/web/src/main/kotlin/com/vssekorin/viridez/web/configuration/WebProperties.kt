package com.vssekorin.viridez.web.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "web")
class WebProperties {
    lateinit var frontUrl: String
}
