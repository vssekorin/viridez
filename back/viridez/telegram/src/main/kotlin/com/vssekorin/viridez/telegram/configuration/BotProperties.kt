package com.vssekorin.viridez.telegram.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "bot")
class BotProperties {

    lateinit var token: String
    lateinit var adminTelegramId: String
}
