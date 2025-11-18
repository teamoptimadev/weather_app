package com.example.weather_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;

public class DetailWeatherActivity extends AppCompatActivity {

    TextView cityTextView;
     TextView dateTextView;
     ImageView weatherIcon;
     TextView temperatureTextView;
     TextView descriptionTextView;

     TextView humidityValue;
     TextView windValue;
     MaterialCardView detailsCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_weather);

        cityTextView = findViewById(R.id.cityTextView);
        dateTextView = findViewById(R.id.dateTextView);
        weatherIcon = findViewById(R.id.weatherIcon);
        temperatureTextView = findViewById(R.id.temperatureTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);


        detailsCard = findViewById(R.id.detailsCard);
        humidityValue = findViewById(R.id.humidityValue);
        windValue = findViewById(R.id.windValue);


        String city = getIntent().getStringExtra("city");
        String date = getIntent().getStringExtra("date");
        String temperature = getIntent().getStringExtra("temperature");
        String description = getIntent().getStringExtra("description");
        int imageRes = getIntent().getIntExtra("image", R.drawable.sunny);


        String humidity = getIntent().getStringExtra("humidity_value");
        String windSpeed = getIntent().getStringExtra("wind_value");


        if (city != null) {
            cityTextView.setText(city);
        } else {
            cityTextView.setText("N/A");
        }

        if (date != null) {
            dateTextView.setText(date);
        } else {
            dateTextView.setText("Today");
        }

        if (temperature != null) {
            temperatureTextView.setText(temperature);
        } else {
            temperatureTextView.setText("--°C");
        }

        if (description != null) {
            descriptionTextView.setText(description);
        } else {
            descriptionTextView.setText("Weather Data Unavailable");
        }

        weatherIcon.setImageResource(imageRes);

        if (humidity != null) {
            humidityValue.setText(humidity);
        } else {
            humidityValue.setText("--%");
        }

        if (windSpeed != null) {
            windValue.setText(windSpeed);
        } else {
            windValue.setText("-- km/h");
        }
    }
}