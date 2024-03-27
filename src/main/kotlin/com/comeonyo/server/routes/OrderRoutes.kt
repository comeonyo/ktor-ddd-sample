package com.comeonyo.server.routes

import com.comeonyo.domain.application.order.OrderApplicationService
import com.comeonyo.domain.application.order.dto.ProcessOrderRequest
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import org.koin.ktor.ext.inject

fun Route.orderRoutes() {
    val orderApplicationService by inject<OrderApplicationService>()

    route("/orders") {
        post {
            val dto = call.receive<ProcessOrderRequest>()
            val processedOrder = orderApplicationService.processOrder(dto)

            call.respond(
                HttpStatusCode.Created,
                processedOrder,
            )
        }

        get {
            call.respond(
                HttpStatusCode.OK,
                orderApplicationService.getOrders(),
            )
        }

        get("/{id}") {
            call.respond(
                HttpStatusCode.OK,
                orderApplicationService.getOrderById(call.parameters["id"]!!.toInt()),
            )
        }
    }
}
