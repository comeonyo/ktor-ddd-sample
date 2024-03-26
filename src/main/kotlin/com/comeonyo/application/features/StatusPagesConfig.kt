package com.comeonyo.application.features

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond

fun Application.configureExceptionHandling() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            val statusCode =
                when (cause) {
                    is IllegalArgumentException -> HttpStatusCode.BadRequest
                    is NoSuchElementException -> HttpStatusCode.NotFound
                    else -> HttpStatusCode.InternalServerError
                }
            call.respond(statusCode, mapOf("status" to statusCode.value.toString(), "message" to cause.localizedMessage))
        }
    }
}
