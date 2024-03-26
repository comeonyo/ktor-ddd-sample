package com.comeonyo.domain.domain.user

import org.jetbrains.exposed.sql.Table

object UserTable : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", length = 255)
    val email = varchar("email", length = 255)
    val password = varchar("password", length = 255)

    override val primaryKey = PrimaryKey(id)
}
