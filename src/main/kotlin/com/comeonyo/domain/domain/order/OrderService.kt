package com.comeonyo.domain.domain.order

class OrderService(
    private val orderRepository: OrderRepository,
) {
    fun createOrder(
        userId: Int,
        productId: Int,
    ): Order {
        return orderRepository.createOrder(userId, productId)
    }

    fun getOrders(): List<Order> {
        return orderRepository.getOrders()
    }

    fun getOrderById(id: Int): Order {
        return orderRepository.getOrderById(id) ?: throw NoSuchElementException("Order not found. id: $id")
    }
}
