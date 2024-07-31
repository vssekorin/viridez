package com.vssekorin.viridez.application

import com.vssekorin.viridez.api.ApiMarkerClass
import com.vssekorin.viridez.core.CoreMarkerClass
import com.vssekorin.viridez.telegram.ViridezBotRunner
import com.vssekorin.viridez.web.WebMarkerClass
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackageClasses = [
        ViridezApplication::class,
        CoreMarkerClass::class,
        ApiMarkerClass::class,
        WebMarkerClass::class,
        ViridezBotRunner::class,
    ]
)
@EnableConfigurationProperties
class ViridezApplication

fun main(args: Array<String>) {
    runApplication<ViridezApplication>(*args)
}
