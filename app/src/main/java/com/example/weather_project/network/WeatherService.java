package com.example.weather_project.network;


import com.example.weather_project.model.DayWeather;
import com.example.weather_project.model.HourWeather;
import com.example.weather_project.model.WeatherRecord;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


/* Classe Serviço
 
    ver documentação https://square.github.io/retrofit/ 
 */
public interface WeatherService {


    @Headers({
        "Accept: application/json",
        "User-Agent: Android App"
    })
    @GET("weather")
    Call<HourWeather> getWeatherForCity(@Query("q") String city, @Query("appid") String id );
    
    
    @GET("forecast/daily")
    Call<DayWeather> getDailyWeatherForCity(@Path("username") String pathvar, @Query("q") String queryvar);

}