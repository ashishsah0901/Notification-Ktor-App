package com.example.onesignalnotification.data.remote

import io.ktor.client.*
import io.ktor.client.request.*

class NotificationServiceImpl(
    private val client: HttpClient
): NotificationService {

    override suspend fun getNotification(title: String, description: String) {
        try {
            client.get<String> {
                url(NotificationService.SEND_NOTIFICATION)
                parameter("title",title)
                parameter("description",description)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}