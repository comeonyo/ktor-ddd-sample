package com.comeonyo.domain.domain.product

import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class ProductRepositoryImpl : ProductRepository {
    override fun createProduct(
        name: String,
        price: Int,
    ): Product {
        var productId: Int? = null
        transaction {
            productId = ProductTable.insert {
                it[ProductTable.name] = name
                it[ProductTable.price] = price.toBigDecimal()
            } get ProductTable.id
        }
        return getProductById(productId!!)!!
    }

    override fun getProducts(): List<Product> {
        return transaction {
            ProductTable.selectAll()
                .map {
                    Product(
                        id = it[ProductTable.id],
                        name = it[ProductTable.name],
                        price = it[ProductTable.price].toInt(),
                    )
                }
        }
    }

    override fun getProductById(id: Int): Product? {
        return transaction {
            ProductTable.select { ProductTable.id eq id }
                .map {
                    Product(
                        id = it[ProductTable.id],
                        name = it[ProductTable.name],
                        price = it[ProductTable.price].toInt(),
                    )
                }.firstOrNull()
        }
    }

    fun getProductByName(name: String): Product? {
        return transaction {
            ProductTable.select { ProductTable.name eq name }
                .map {
                    Product(
                        id = it[ProductTable.id],
                        name = it[ProductTable.name],
                        price = it[ProductTable.price].toInt(),
                    )
                }.firstOrNull()
        }
    }

    override fun existsProductById(id: Int): Boolean {
        return getProductById(id) != null
    }

    override fun existsProductByName(name: String): Boolean {
        return getProductByName(name) != null
    }
}
