package com.example.practika14_rasulov

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

lateinit var textView: TextView
lateinit var button2: Button

class Add_request : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_request)
        textView = findViewById(R.id.textView)
        button2 = findViewById(R.id.button2)


       // val executorService: ExecutorService = Executors.newSingleThreadExecutor()
        button2.setOnClickListener {
            val intent: Intent = Intent(this, Show_request::class.java)
            startActivity(intent)
        }
    }
}
/*
@Throws(IOException::class)
fun httpRequest(urlString: String):String {
    val url = URL(urlString)
    val connection = url.openConnection() as HttpURLConnection
    connection.requestMethod = "GET"
    var data: Int = connection.inputStream.read()
    var str = ""
    while (data != -1){
        str += data.toChar()
        data = connection.inputStream.read()
    }
    return str
}*/
