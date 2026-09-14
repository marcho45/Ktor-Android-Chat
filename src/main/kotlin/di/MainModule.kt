package com.plcoding.di

import com.plcoding.data.MessageDataSource
import com.plcoding.data.MessageDataSourceImpl
import com.plcoding.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        val connectionString = System.getenv("MONGO_URI") ?: "mongodb://localhost:27017"
        println("DEBUG: MONGO_URI env var = ${System.getenv("MONGO_URI")}")
        println("DEBUG: Using connection string = $connectionString")
        KMongo.createClient(connectionString)
            .coroutine
            .getDatabase("message_db_marko")
    }
    single<MessageDataSource> {
        MessageDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }
}