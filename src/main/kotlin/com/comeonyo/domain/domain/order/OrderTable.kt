package com.comeonyo.domain.domain.order

import org.jetbrains.exposed.sql.Table

object OrderTable : Table() {
    val id = integer("id").autoIncrement()
    val userId = integer("user_id")
    val productId = integer("product_id")

    override val primaryKey = PrimaryKey(id)
}
