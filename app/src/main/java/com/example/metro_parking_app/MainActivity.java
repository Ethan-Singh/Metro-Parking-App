package com.example.metro_parking_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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

        FacilityMap facilityMap = new FacilityMap();
        List<String> facilityIds = facilityMap.getAllFacilityIds();
        FacilityList facilityList = new FacilityList();
        AtomicInteger calls = new AtomicInteger(0);

//        RecyclerView recyclerViewFacilities = findViewById(R.id.recyclerViewFacilities);
        RecyclerView recyclerViewLine = findViewById(R.id.recyclerViewLine);


        //uses an executor to complete an asynchronous network call
        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            ApiRequest apiRequest = new ApiRequest(ApiKey.readApiKey(this));
            for (String currFacilityId : facilityIds) {
                // increment each call
                int totalCalls = calls.incrementAndGet();
                Facility currFacility = apiRequest.CarParkAPI(currFacilityId);
                facilityList.addFacility(currFacility);
                currFacility.setLine(facilityMap.getKeyfromValue(currFacilityId));
                // uses handler for 200 millisecond delay (+10 millisecond buffer)
                handler.postDelayed(() -> {
                    // if all calls have been completed
                    if (totalCalls == facilityIds.size()) {
                        // updates UI on the main thread
                        runOnUiThread(() -> {
                            try {
//                               FacilityAdapter facilityAdapter = new FacilityAdapter(facilityList.getFacilityList());
//                               RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//                               recyclerViewFacilities.setLayoutManager(layoutManager);
//                               recyclerViewFacilities.setAdapter(facilityAdapter);

                                LineAdapter lineAdapter = new LineAdapter(LineList.getLineList(), LineList.getLineColour());
                                RecyclerView.LayoutManager layoutManagerTwo = new GridLayoutManager(this, 2);
                                recyclerViewLine.setLayoutManager(layoutManagerTwo);
                                recyclerViewLine.setAdapter(lineAdapter);
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
