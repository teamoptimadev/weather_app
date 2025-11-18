package com.example.weather_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailWeatherActivity extends AppCompatActivity {

    TextView textView;
    ImageView weatherIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_weather);

        textView = findViewById(R.id.weatherText);
        weatherIcon = findViewById(R.id.weatherIcon);

        String city = getIntent().getStringExtra("city");
        String weather = getIntent().getStringExtra("weather");
        int imageRes = getIntent().getIntExtra("image", -1);

        textView.setText(city + "\n" + weather);

        if (imageRes != -1) {
            weatherIcon.setImageResource(imageRes);
        }
    }
}
