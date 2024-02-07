package com.example.metro_parking_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> allFacilityIds = new FacilityMap().getAllFacilityIds();
        FacilityList facilityList = new FacilityList();
        AtomicInteger completedCalls = new AtomicInteger(0);

        RecyclerView recyclerViewFacilities = findViewById(R.id.recyclerViewFacilities);

        //uses an executor to complete an asynchronous network call
        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            ApiRequest apiRequest = new ApiRequest(ApiKey.readApiKey(this));
            for (String facilityId: allFacilityIds) {
                // increment each call
                int callCount = completedCalls.incrementAndGet();
                facilityList.addFacility(apiRequest.CarParkAPI(facilityId));
                // uses handler for 200 millisecond delay (+10 millisecond buffer)
                handler.postDelayed(() -> {
                    // if all calls have been completed
                    if (callCount == allFacilityIds.size()) {
                        // updates UI on the main thread
                        runOnUiThread(() -> {
                            try {
                                FacilityAdapter facilityAdapter = new FacilityAdapter(facilityList.getList());
                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
                                recyclerViewFacilities.setLayoutManager(layoutManager);
                                recyclerViewFacilities.setAdapter(facilityAdapter);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                    }
                }, 210);
            }
        });

    }
}
