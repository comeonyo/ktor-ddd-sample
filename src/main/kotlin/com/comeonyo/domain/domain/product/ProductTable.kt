package com.comeonyo.domain.domain.product

import org.jetbrains.exposed.sql.Table

object ProductTable : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", length = 255)
    val price = decimal("price", precision = 10, scale = 2)

    override val primaryKey = PrimaryKey(id)
}
