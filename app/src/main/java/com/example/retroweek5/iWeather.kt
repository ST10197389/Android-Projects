package com.example.retroweek5

import com.example.retroweek5.models.Hour3Forcast
import com.example.retroweek5.models.WeatherForcast
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query




interface iWeather {

    @GET("/data/2.5/forecast")
suspend fun getWeekData(@Query("lat")lat:String,@Query("lon")lon:String,@Query("appid") appid:String) :retrofit2.Response<WeatherForcast>
}
//?lat=-25.7459277&lon=28.1879101&appid=ea9b0cee5aafbd6a8be17938bb12f9fd