package com.comeonyo.domain.domain.user

interface UserRepository {
    fun createUser(
        name: String,
        email: String,
        encodedPassword: String,
    ): User

    fun getUsers(): List<User>

    fun getUserById(id: Int): User?

    fun getUserByName(name: String): User?

    fun existsById(id: Int): Boolean

    fun existsByName(name: String): Boolean
}
