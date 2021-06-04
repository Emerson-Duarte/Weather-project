package com.example.weather_project.network;


import com.example.weather_project.model.WeatherRecord;



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
    Call<DailyWeather> getDailyWeatherForCity(@Path("username") String pathvar, @Query("q") String queryvar);

}