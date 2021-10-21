package com.example.onesignalnotification.data.remote

import io.ktor.client.*

interface NotificationService {

    suspend fun getNotification(title: String, description: String)

    companion object {
        const val SEND_NOTIFICATION = "http://192.168.48.184:8080/sendNotification"
        private var INSTANCE: NotificationService? = null
        fun create(client: HttpClient): NotificationService {
            return INSTANCE ?: NotificationServiceImpl(client).also {
                INSTANCE = it
            }
        }
    }

}