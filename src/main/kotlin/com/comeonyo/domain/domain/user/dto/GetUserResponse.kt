package com.comeonyo.domain.domain.user.dto

import com.comeonyo.domain.domain.user.User
import kotlinx.serialization.Serializable

@Serializable
data class GetUserResponse(
    val id: Int,
    val name: String,
    val email: String,
) {
    companion object {
        fun fromUser(user: User): GetUserResponse {
            return GetUserResponse(
                id = user.id.value,
                name = user.name,
                email = user.email,
            )
        }
    }
}
