package com.comeonyo.domain.domain.product.dto

import com.comeonyo.domain.domain.product.Product
import kotlinx.serialization.Serializable

@Serializable
data class GetProductResponse(
    val id: Int,
    val name: String,
    val price: Int,
) {
    companion object {
        fun fromProduct(product: Product): GetProductResponse {
            return GetProductResponse(
                id = product.id,
                name = product.name,
                price = product.price,
            )
        }
    }
}
