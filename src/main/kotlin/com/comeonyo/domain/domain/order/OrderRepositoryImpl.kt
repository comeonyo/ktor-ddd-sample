package com.comeonyo.domain.domain.order

import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class OrderRepositoryImpl : OrderRepository {
    override fun createOrder(
        userId: Int,
        productId: Int,
    ): Order {
        var orderId: Int? = null
        transaction {
            orderId = OrderTable.insert {
                it[OrderTable.userId] = userId
                it[OrderTable.productId] = productId
            } get OrderTable.id
        }
        return getOrderById(orderId!!)!!
    }

    override fun getOrders(): List<Order> {
        return transaction {
            OrderTable.selectAll()
                .map {
                    Order(
                        id = it[OrderTable.id],
                        userId = it[OrderTable.userId],
                        productId = it[OrderTable.productId],
                    )
                }
        }
    }

    override fun getOrderById(id: Int): Order? {
        return transaction {
            OrderTable.select { OrderTable.id eq id }
                .map {
                    Order(
                        id = it[OrderTable.id],
                        userId = it[OrderTable.userId],
                        productId = it[OrderTable.productId],
                    )
                }.firstOrNull()
        }
    }
}
