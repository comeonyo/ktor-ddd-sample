package com.comeonyo.domain.domain.product

interface ProductRepository {
    fun createProduct(
        name: String,
        price: Int,
    ): Product

    fun getProducts(): List<Product>

    fun getProductById(id: Int): Product?

    fun existsProductById(id: Int): Boolean

    fun existsProductByName(name: String): Boolean
}
