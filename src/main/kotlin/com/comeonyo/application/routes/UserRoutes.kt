package com.comeonyo.application.routes

import com.comeonyo.domain.application.user.UserApplicationService
import com.comeonyo.domain.application.user.dto.RegisterUserRequest
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import org.koin.ktor.ext.inject

fun Route.userRoutes() {
    val userApplicationService by inject<UserApplicationService>()

    route("/users") {
        post {
            val dto = call.receive<RegisterUserRequest>()
            val registeredUser = userApplicationService.registerUser(dto)

            call.respond(
                HttpStatusCode.Created,
                registeredUser,
            )
        }

        get {
            call.respond(
                HttpStatusCode.OK,
                userApplicationService.getUsers(),
            )
        }

        get("/{id}") {
            call.respond(
                HttpStatusCode.OK,
                userApplicationService.getUserById(call.parameters["id"]!!.toInt()),
            )
        }
    }
}
