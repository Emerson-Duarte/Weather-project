package com.example.weather_project.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.weather_project.Constants;
import com.example.weather_project.R;
import com.example.weather_project.model.HourWeather;
import com.example.weather_project.model.User;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private User user = new User("User11", "Porto Akleger", Profile.SIMPLE);

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

        call.enque(new Callback<HourWeather>() {
                @Override
                public void onSuccess(HourWeather data) {
                    populaDadosTela(data);
                }

                @Override
                public void onError(Exception error) {
                    Toast.makeText(getBaseContext(), "Network error", Toast.LENGTH_SHORT).show();
                }
        };
    }

    private void populaDadosTela(HourWeather data) {
            textviewTemnperatura.setText(data.getTemp());
    }
}