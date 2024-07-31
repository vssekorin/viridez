plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "viridez"

include("application")

include("core")
include("api")
include("web")
include("telegram")
