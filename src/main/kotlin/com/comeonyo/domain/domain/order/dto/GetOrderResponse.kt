package com.comeonyo.domain.domain.order.dto

import kotlinx.serialization.Serializable

@Serializable
data class GetOrderResponse(
    val id: Int,
    val userId: Int,
    val productId: Int,
) {
    companion object {
        fun fromOrder(order: com.comeonyo.domain.domain.order.Order): GetOrderResponse {
            return GetOrderResponse(
                id = order.id,
                userId = order.userId,
                productId = order.productId,
            )
        }
    }
}
