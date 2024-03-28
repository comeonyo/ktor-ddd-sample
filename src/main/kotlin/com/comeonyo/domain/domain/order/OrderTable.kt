package com.comeonyo.domain.domain.order

import org.jetbrains.exposed.dao.id.IntIdTable

object OrderTable : IntIdTable() {
    val userId = integer("user_id")
    val productId = integer("product_id")
}
