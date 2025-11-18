package com.example.weather_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView; // Added for the image view

public class HomeActivity extends AppCompatActivity {

     TextView titleTextView;
     TextView listTitleTextView;
     ImageView weatherImageView;
     ListView listView;

    String[] cities = {"Delhi", "Mumbai", "Bangalore", "Chennai", "Hyderabad"};
    String[] dates = {"Today, Nov 18", "Today, Nov 18", "Today, Nov 18", "Today, Nov 18", "Today, Nov 18"};


    String[] temperatures = {"32°C", "30°C", "27°C", "29°C", "28°C"};
    String[] descriptions = {"Sunny", "Humid", "Cloudy", "Hot", "Rainy"};

    String[] humidityValues = {"40%", "85%", "60%", "70%", "92%"};
    String[] windSpeeds = {"15 km/h", "8 km/h", "12 km/h", "10 km/h", "5 km/h"};


    int[] weatherImages = {
            R.drawable.sunny,
            R.drawable.humid,
            R.drawable.cloudy,
            R.drawable.sunny,
            R.drawable.rainy
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        titleTextView = findViewById(R.id.title);
        weatherImageView = findViewById(R.id.weatherImage);
        listTitleTextView = findViewById(R.id.listTitle);
        listView = findViewById(R.id.listView);

        String[] listItems = new String[cities.length];
        for (int i = 0; i < cities.length; i++) {
            listItems[i] = cities[i] + " - " + temperatures[i];
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listItems
        );
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(HomeActivity.this, DetailWeatherActivity.class);

                intent.putExtra("city", cities[position]);
                intent.putExtra("date", dates[position]);
                intent.putExtra("temperature", temperatures[position]);
                intent.putExtra("description", descriptions[position]);

                intent.putExtra("humidity_value", humidityValues[position]);
                intent.putExtra("wind_value", windSpeeds[position]);

                intent.putExtra("image", weatherImages[position]);

                startActivity(intent);
            }
        });
    }
}