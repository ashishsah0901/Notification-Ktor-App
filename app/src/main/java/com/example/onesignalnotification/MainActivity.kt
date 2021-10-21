package com.example.onesignalnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onesignalnotification.data.remote.NotificationService
import com.example.onesignalnotification.databinding.ActivityMainBinding
import io.ktor.client.*
import io.ktor.client.engine.android.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var client: HttpClient? = null
    private var service: NotificationService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(client ==  null) {
            client = HttpClient(Android)
        }
        if(service == null) {
            service = NotificationService.create(client!!)
        }
        binding.send.setOnClickListener {
            if(service == null) {
                if (client == null) {
                    client = HttpClient(Android)
                }
                service = NotificationService.create(client!!)
            }
            sendNotification()
            binding.description.text = null
            binding.title.text = null
        }
    }

    private fun sendNotification() {
        GlobalScope.launch {
            service!!.getNotification(binding.title.text.toString(), binding.description.text.toString())
        }
    }
}