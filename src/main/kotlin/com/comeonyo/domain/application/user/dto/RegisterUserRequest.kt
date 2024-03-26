package com.comeonyo.domain.application.user.dto

import kotlinx.serialization.Serializable

@Serializable
data class RegisterUserRequest(
    val name: String,
    val email: String,
    val encodedPassword: String,
)
