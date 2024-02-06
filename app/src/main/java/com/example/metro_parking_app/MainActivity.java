package com.example.metro_parking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    private final List<String> facilityIdList = Arrays.asList(
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31",
            "32", "33", "486", "487", "488", "489", "490"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);
        AtomicInteger completedCalls = new AtomicInteger(0);
        FacilityList facilityList = new FacilityList();

        //uses an executor to complete an asynchronous network call
        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            ApiRequest apiRequest = new ApiRequest(ApiKey.readApiKey(this));
            for (String facilityId : facilityIdList) {
                facilityList.addFacility(apiRequest.CarParkAPI(facilityId));

                // uses handler for 200 millisecond delay (+10 buffer)
                handler.postDelayed(() -> {
                    // Increment the counter after each completed call
                    int currentCount = completedCalls.incrementAndGet();

                    // checks if all calls have been completed
                    if (currentCount == facilityIdList.size()) {
                        // updates UI on the main thread after all network calls are complete
                        runOnUiThread(() -> {
                            textViewResult.setText(FacilityFormatter.format(facilityList.getList().get(0)));
                        });
                    }
                }, 210);
            }
        });



    }
}
