package com.comeonyo.domain.domain.user

import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepositoryImpl : UserRepository {
    override fun createUser(
        name: String,
        email: String,
        encodedPassword: String,
    ): User {
        var userId: Int? = null
        transaction {
            userId = UserTable.insert {
                it[UserTable.name] = name
                it[UserTable.email] = email
                it[password] = encodedPassword
            } get UserTable.id
        }
        return getUserById(userId!!)!!
    }

    override fun getUsers(): List<User> {
        return transaction {
            UserTable.selectAll().map {
                User(
                    id = it[UserTable.id],
                    name = it[UserTable.name],
                    email = it[UserTable.email],
                    password = it[UserTable.password],
                )
            }
        }
    }

    override fun getUserById(id: Int): User? {
        return transaction {
            UserTable.select { UserTable.id eq id }.map {
                User(
                    id = it[UserTable.id],
                    name = it[UserTable.name],
                    email = it[UserTable.email],
                    password = it[UserTable.password],
                )
            }.firstOrNull()
        }
    }

    override fun getUserByName(name: String): User? {
        return transaction {
            UserTable.select { UserTable.name eq name }.map {
                User(
                    id = it[UserTable.id],
                    name = it[UserTable.name],
                    email = it[UserTable.email],
                    password = it[UserTable.password],
                )
            }.firstOrNull()
        }
    }

    override fun existsById(id: Int): Boolean {
        return getUserById(id) != null
    }

    override fun existsByName(name: String): Boolean {
        return getUserByName(name) != null
    }
}
