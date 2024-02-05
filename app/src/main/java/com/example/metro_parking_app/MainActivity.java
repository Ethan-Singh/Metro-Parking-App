package com.example.metro_parking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private Facility facility;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);

        //uses an executor to complete an asynchronous network call
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            // network call
            ApiKey apiKey = new ApiKey();
            ApiRequest apiRequest = new ApiRequest(apiKey.readApiKey(this));
            facility = apiRequest.CarParkAPI();

            // Update UI on the main thread after the network call completes
            runOnUiThread(() -> {
                StringBuilder formattedStringBuilder = new StringBuilder();
                formattedStringBuilder.append("Facility Name: ").append(facility.getFacilityName())
                        .append("\nTotal Spots: ").append(facility.getSpots())
                        .append("\n\nParking Bays:");

                List<Zone> zones = facility.getZones();
                for (Zone zone : zones) {
                    formattedStringBuilder.append("\n").append(zone.getZoneName())
                            .append("\n  Available Spots: ").append(zone.getSpots())
                            .append("\n  Occupancy: ").append(zone.getOccupancy().getTotal()).append("\n");
                }

                String formattedString = formattedStringBuilder.toString();
                textViewResult.setText(formattedString);
            });
        });

    }
}
