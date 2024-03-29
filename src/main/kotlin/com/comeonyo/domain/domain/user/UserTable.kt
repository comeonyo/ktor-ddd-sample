package com.comeonyo.domain.domain.user

import org.jetbrains.exposed.dao.id.IntIdTable

object UserTable : IntIdTable() {
    val name = varchar("name", length = 255)
    val email = varchar("email", length = 255)
    val password = varchar("password", length = 255)
}
