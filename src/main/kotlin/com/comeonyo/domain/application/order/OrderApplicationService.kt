package com.comeonyo.domain.application.order

import com.comeonyo.domain.application.order.dto.ProcessOrderRequest
import com.comeonyo.domain.domain.order.OrderService
import com.comeonyo.domain.domain.order.dto.GetOrderResponse
import com.comeonyo.domain.domain.product.ProductService
import com.comeonyo.domain.domain.user.UserService

class OrderApplicationService(
    private val userService: UserService,
    private val productService: ProductService,
    private val orderService: OrderService,
) {
    fun processOrder(request: ProcessOrderRequest): GetOrderResponse {
        require(userService.checkUserValid(request.userId)) { "User not found" }
        require(productService.checkProductValid(request.productId)) { "Product not found" }

        // 상품 재고 확인, 주문 가능 여부 확인 등의 로직 구현

        return GetOrderResponse.fromOrder(orderService.createOrder(request.userId, request.productId))
    }

    fun getOrders(): List<GetOrderResponse> {
        return orderService.getOrders().map { GetOrderResponse.fromOrder(it) }
    }

    fun getOrderById(id: Int): GetOrderResponse {
        return GetOrderResponse.fromOrder(orderService.getOrderById(id))
    }
}
