package com.example.weather_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    ListView listView;

    String[] cities = {"Delhi", "Mumbai", "Bangalore", "Chennai", "Hyderabad"};
    String[] weather = {"32°C Sunny", "30°C Humid", "27°C Cloudy", "29°C Hot", "28°C Rainy"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int[] weatherImages = {
                R.drawable.sunny,
                R.drawable.humid,
                R.drawable.cloudy,
                R.drawable.hot,
                R.drawable.rainy
        };



        listView = findViewById(R.id.listView);


        String[] combined = new String[cities.length];
        for (int i = 0; i < cities.length; i++) {
            combined[i] = cities[i] + " - " + weather[i];
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                combined
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeActivity.this, DetailWeatherActivity.class);
                intent.putExtra("city", cities[position]);
                intent.putExtra("weather", weather[position]);
                intent.putExtra("image", weatherImages[position]);
                startActivity(intent);
            }
        });
    }
}