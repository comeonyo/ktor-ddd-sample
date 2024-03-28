package com.comeonyo.domain.domain.order

import org.jetbrains.exposed.sql.transactions.transaction

class OrderRepositoryImpl : OrderRepository {
    override fun createOrder(
        userId: Int,
        productId: Int,
    ): Order =
        transaction {
            Order.new {
                this.userId = userId
                this.productId = productId
            }
        }

    override fun getOrders(): List<Order> =
        transaction {
            Order.all().toList()
        }

    override fun getOrderById(id: Int): Order? =
        transaction {
            Order.findById(id)
        }
}
