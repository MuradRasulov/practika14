package com.example.practika14_rasulov

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

lateinit var button3 :Button
//lateinit var button4 : Button
lateinit var textView2: TextView
lateinit var button5: Button
lateinit var button6: Button
lateinit var button7: Button
lateinit var button8: Button
lateinit var button9: Button
lateinit var button10: Button
lateinit var button11: Button

class Show_request : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_request)
        button3 = findViewById(R.id.button3)
        //button4 = findViewById(R.id.button4)
        textView2 = findViewById(R.id.textView2)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        button10 = findViewById(R.id.button10)
        button11 = findViewById(R.id.button11)
        val executorService: ExecutorService = Executors.newSingleThreadExecutor()

        button3.setOnClickListener {
            val intent: Intent = Intent(this, Add_request::class.java)
            startActivity(intent)
        }
        button5.setOnClickListener{
            textView2.text = executorService.submit(Callable {
                httpRequest("http://smartroom.ectsserver.edu/api/Room/light/poweron/0")
            }).get()
        }
        button6.setOnClickListener{
            textView2.text = executorService.submit(Callable {
                httpRequest("http://smartroom.ectsserver.edu/api/Room/light/poweron/1")
            }).get()
        }
        button7.setOnClickListener{
            textView2.text = executorService.submit(Callable {
                httpRequest("http://smartroom.ectsserver.edu/api/Room/light/poweron/2")
            }).get()
        }
        button8.setOnClickListener{
            textView2.text = executorService.submit(Callable {
                httpRequest("http://smartroom.ectsserver.edu/api/Room/light/poweron/3")
            }).get()
        }
        button9.setOnClickListener{
            textView2.text = executorService.submit(Callable {
                httpRequest("http://smartroom.ectsserver.edu/api/room/light/setcolor/0")
            }).get()
        }
        button10.setOnClickListener{
            textView2.text = executorService.submit(Callable {
                httpRequest("http://smartroom.ectsserver.edu/api/room/light/setcolor/1")
            }).get()
        }
        button11.setOnClickListener{
            textView2.text = executorService.submit(Callable {
                httpRequest("http://smartroom.ectsserver.edu/api/room/light/setcolor/2")
            }).get()
        }
        /*button4.setOnClickListener{
            textView2.text = executorService.submit(Callable {
                httpRequest("http://api.kanye.rest/refresh")
            }).get().kanye
        }*/

    }
}
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
}