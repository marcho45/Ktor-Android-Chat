package com.plcoding.data

import com.plcoding.data.Model.Message

interface MessageDataSource {

    suspend fun getAllMessages(): List<Message>
    suspend fun insertMessage(message: Message)
}