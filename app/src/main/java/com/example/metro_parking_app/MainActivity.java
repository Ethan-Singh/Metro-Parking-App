package com.example.metro_parking_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.example.metro_parking_app.databinding.ActivityMainBinding;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        FacilityMap facilityMap = new FacilityMap();
        List<String> facilityIds = facilityMap.getAllFacilityIds();
        FacilityList facilityList = new FacilityList();
        AtomicInteger calls = new AtomicInteger(0);

      RecyclerView recyclerViewFacilities = binding.recyclerViewFacilities;
        RecyclerView recyclerViewLine = binding.recyclerViewLine;


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
                               FacilityAdapter facilityAdapter = new FacilityAdapter(facilityList);
                               RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
                               recyclerViewFacilities.setLayoutManager(layoutManager);
                               recyclerViewFacilities.setAdapter(facilityAdapter);


                                LineList lineList = new LineList();
                                lineList.addLine(new Line (R.drawable.sydney_metro_line, Color.parseColor("#008C94"), 0));
                                lineList.addLine(new Line (R.drawable.tfnsw_t1, Color.parseColor("#f6910f"), 1));
                                lineList.addLine(new Line (R.drawable.tfnsw_t2, Color.parseColor("#0697d1"), 2));
                                lineList.addLine(new Line (R.drawable.tfnsw_t3, Color.parseColor("#f25b18"), 3));
                                lineList.addLine(new Line (R.drawable.tfnsw_t4, Color.parseColor("#1e56a8"), 4));
                                lineList.addLine(new Line (R.drawable.tfnsw_t5, Color.parseColor("#c41090"), 5));
                                lineList.addLine(new Line (R.drawable.tfnsw_t6, Color.parseColor("#4664af"),6));
                                lineList.addLine(new Line (R.drawable.tfnsw_t7, Color.parseColor("#697c8a"),7));
                                lineList.addLine(new Line (R.drawable.tfnsw_t8, Color.parseColor("#0a9649"),8));
                                lineList.addLine(new Line (R.drawable.tfnsw_t9, Color.parseColor("#d21a2d"),9));
                                lineList.addLine(new Line (R.drawable.tfnsw_sco, Color.parseColor("#1e56a8"),10));
                                lineList.addLine(new Line (R.drawable.tfnsw_ccn, Color.parseColor("#d01f31"),11));
                                lineList.addLine(new Line (R.drawable.sydney_b_line, Color.parseColor("#FFB81C"),12));


                              LineAdapter lineAdapter = new LineAdapter(lineList);
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
