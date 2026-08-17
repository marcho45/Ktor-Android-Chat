package com.plcoding.session

import kotlinx.serialization.Serializable

@Serializable
data class ChatSession(
    val username: String,
    val sessionId: String,
)
