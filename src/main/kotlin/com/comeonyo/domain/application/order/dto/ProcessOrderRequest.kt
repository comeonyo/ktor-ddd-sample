package com.comeonyo.domain.application.order.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProcessOrderRequest(
    val userId: Int,
    val productId: Int,
)
