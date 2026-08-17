package com.plcoding

import com.plcoding.room.RoomController
import com.plcoding.routes.chatSocket
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import java.time.Duration
import io.ktor.server.sessions.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()

    routing {
        get("/") {
            call.respondText("Hello, World!")
        }

        chatSocket(roomController)
    }
}