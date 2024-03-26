package com.comeonyo.domain.application.product

import com.comeonyo.domain.application.product.dto.RegisterProductRequest
import com.comeonyo.domain.domain.product.ProductService
import com.comeonyo.domain.domain.product.dto.GetProductResponse

class ProductApplicationService(
    private val productService: ProductService,
) {
    fun registerProduct(request: RegisterProductRequest): GetProductResponse {
        return GetProductResponse.fromProduct(productService.registerProduct(request.name, request.price))
    }

    fun getProducts(): List<GetProductResponse> {
        return productService.getProducts().map { GetProductResponse.fromProduct(it) }
    }

    fun getProductById(id: Int): GetProductResponse {
        return GetProductResponse.fromProduct(productService.getProductById(id))
    }
}
