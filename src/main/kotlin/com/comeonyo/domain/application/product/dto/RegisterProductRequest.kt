package com.comeonyo.domain.application.product.dto

import kotlinx.serialization.Serializable

@Serializable
data class RegisterProductRequest(
    val name: String,
    val price: Int,
)
