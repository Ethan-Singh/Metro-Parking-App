package com.example.metro_parking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private Facility facility;

    private String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);

        //uses an executor to complete an asynchronous network call
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            //network call
            ApiKey apiKey = new ApiKey();
            ApiRequest apiRequest = new ApiRequest(apiKey.readApiKey(this));
            facility = apiRequest.CarParkAPI();
            result = facility.getFacilityName();
            //return 'result's on main thread
            runOnUiThread(() -> textViewResult.setText(result));
        });
    }
}
