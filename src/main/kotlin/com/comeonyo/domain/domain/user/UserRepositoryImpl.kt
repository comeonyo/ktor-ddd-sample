package com.comeonyo.domain.domain.user

import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepositoryImpl : UserRepository {
    override fun createUser(
        name: String,
        email: String,
        encodedPassword: String,
    ): User =
        transaction {
            User.new {
                this.name = name
                this.email = email
                this.password = encodedPassword
            }
        }

    override fun getUsers(): List<User> =
        transaction {
            User.all().toList()
        }

    override fun getUserById(id: Int): User? =
        transaction {
            User.findById(id)
        }

    override fun getUserByName(name: String): User? =
        transaction {
            UserTable.select { UserTable.name eq name }
                .map { User.wrapRow(it) }
                .singleOrNull()
        }

    override fun existsById(id: Int): Boolean {
        return getUserById(id) != null
    }

    override fun existsByName(name: String): Boolean {
        return getUserByName(name) != null
    }
}
