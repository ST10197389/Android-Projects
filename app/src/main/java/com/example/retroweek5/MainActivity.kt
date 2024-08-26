package com.example.retroweek5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val appid = "ea9b0cee5aafbd6a8be17938bb12f9fd"
const val lon = 28.1879101
const val lat = -25.7459277

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {

            val response = api.retrofit.getWeekData(lat.toString(), lon.toString(), appid)

            if (response.isSuccessful){
                launch (Dispatchers.Main){
                    findViewById<TextView>(R.id.Text).setText(response.body().toString())
                }
            }
            else
            {
                Log.v("openapi", response.message())
            }
        }

    }
}