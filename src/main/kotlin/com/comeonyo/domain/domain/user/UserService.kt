package com.comeonyo.domain.domain.user

class UserService(
    private val userRepository: UserRepository,
) {
    fun registerUser(
        name: String,
        email: String,
        encodedPassword: String,
    ): User {
        // validate
        require(!userRepository.existsByName(name)) {
            "User already exists. name: $name"
        }

        return userRepository.createUser(name, email, encodedPassword)
    }

    fun getUsers(): List<User> {
        return userRepository.getUsers()
    }

    fun getUserById(id: Int): User {
        return userRepository.getUserById(id) ?: throw NoSuchElementException("User not found. id: $id")
    }

    fun checkUserValid(id: Int): Boolean {
        return userRepository.existsById(id)
    }
}
