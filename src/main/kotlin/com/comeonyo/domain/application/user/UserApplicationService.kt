package com.comeonyo.domain.application.user

import com.comeonyo.domain.application.user.dto.RegisterUserRequest
import com.comeonyo.domain.domain.user.UserService
import com.comeonyo.domain.domain.user.dto.GetUserResponse

class UserApplicationService(
    private val userService: UserService,
) {
    fun registerUser(request: RegisterUserRequest): GetUserResponse {
        return GetUserResponse.fromUser(
            userService.registerUser(request.name, request.email, request.encodedPassword),
        )
    }

    fun getUsers(): List<GetUserResponse> {
        return userService.getUsers().map { GetUserResponse.fromUser(it) }
    }

    fun getUserById(id: Int): GetUserResponse {
        return GetUserResponse.fromUser(userService.getUserById(id))
    }
}
