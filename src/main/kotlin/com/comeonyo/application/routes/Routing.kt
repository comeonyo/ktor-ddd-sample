package com.comeonyo.application.routes

import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        userRoutes()
        productRoutes()
        orderRoutes()
    }
}
