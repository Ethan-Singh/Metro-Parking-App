package com.example.metro_parking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

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
            ApiRequest apiRequest = new ApiRequest(ApiKey.readApiKey(this));
            facility = apiRequest.CarParkAPI();

            // update UI on the main thread after the network call completes
            runOnUiThread(() -> {
                textViewResult.setText(FacilityFormatter.format(facility));
            });
        });

    }
}
