package com.comeonyo.domain.domain.order

interface OrderRepository {
    fun createOrder(
        userId: Int,
        productId: Int,
    ): Order

    fun getOrders(): List<Order>

    fun getOrderById(id: Int): Order?
}
