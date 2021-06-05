package com.example.weather_project.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.weather_project.Constants;
import com.example.weather_project.R;
import com.example.weather_project.model.HourWeather;
import com.example.weather_project.model.Profile;
import com.example.weather_project.model.User;
import com.example.weather_project.network.WeatherService;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private User user = new User("User11", "Porto Alegre", Profile.SIMPLE, "IMAGEM");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        WeatherService service = retrofit.create(WeatherService.class);

        Call<HourWeather> call = service.getWeatherForCity(user.getCity(), Constants.APP_ID);

        call.enqueue(new Callback<HourWeather>() {
            @Override
            public void onResponse(Call<HourWeather> call, Response<HourWeather> response) {

            };

            @Override
            public void onFailure(Call<HourWeather> call, Throwable t) {

            };

//            @Override
//                public void onSuccess(HourWeather data) {
//                    populaDadosTela(data);
//                }
//
//                @Override
//                public void onFailure(Exception error) {
//                    Toast.makeText(getBaseContext(), "Network error", Toast.LENGTH_SHORT).show();
//                }
        });
    };

    private void populaDadosTela(HourWeather data) {
            textviewTemperatura.setText(data.getTemp());
    }
}