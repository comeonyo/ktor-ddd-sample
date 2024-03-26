package com.comeonyo.application.routes

import com.comeonyo.domain.application.product.ProductApplicationService
import com.comeonyo.domain.application.product.dto.RegisterProductRequest
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import org.koin.ktor.ext.inject

fun Route.productRoutes() {
    val productApplicationService by inject<ProductApplicationService>()

    route("/products") {
        post {
            val dto = call.receive<RegisterProductRequest>()
            val registeredProduct = productApplicationService.registerProduct(dto)

            call.respond(
                HttpStatusCode.Created,
                registeredProduct,
            )
        }

        get {
            call.respond(
                HttpStatusCode.OK,
                productApplicationService.getProducts(),
            )
        }

        get("/{id}") {
            call.respond(
                HttpStatusCode.OK,
                productApplicationService.getProductById(call.parameters["id"]!!.toInt()),
            )
        }
    }
}
