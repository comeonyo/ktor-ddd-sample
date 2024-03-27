package com.comeonyo.server.features

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.callloging.CallLogging

fun Application.configureCallLogging() {
    install(CallLogging) {}
}
