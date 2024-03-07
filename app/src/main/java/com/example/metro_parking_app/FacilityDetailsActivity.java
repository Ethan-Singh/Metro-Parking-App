package com.example.metro_parking_app;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.metro_parking_app.databinding.FacilityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FacilityDetailsActivity extends AppCompatActivity {

    private FacilityMainBinding binding;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FacilityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Toolbar myToolbar = binding.toolbar;
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.toolbar.setNavigationOnClickListener(viewChange -> onBackPressed());
        getSupportActionBar().setTitle("");

        Line lineList = null;

        if (getIntent().hasExtra(MainActivity.NEXT_SCREEN)) {
            lineList = (Line) getIntent().getSerializableExtra(MainActivity.NEXT_SCREEN);
        }
        loadFacilities(lineList);

        //since we're using lambda's lineList has to be final
        final Line finalLineList = lineList;
        swipeRefreshLayout = binding.swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(() -> loadFacilities(finalLineList));

    }

    private void loadFacilities(Line lineList){
        if (lineList != null) {
            getSupportActionBar().setIcon(lineList.getImage());
            FacilityMapData facilityMap = new FacilityMapData();
            List<String> facilityIdsFromLine = facilityMap.getFacilityIdsFromLine(lineList.getId());
            AtomicInteger calls = new AtomicInteger(0);
            ArrayList<Facility> allFacilityApiData = new ArrayList<>();

            Executor executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());

            executor.execute(() -> {
                ApiRequest apiRequest = new ApiRequest(ApiKey.readApiKey(this));
                for (String currFacilityID : facilityIdsFromLine) {
                    int totalCalls = calls.incrementAndGet();
                    Facility currFacility = apiRequest.CarParkAPI(currFacilityID);
                    currFacility.setLine(facilityMap.getLineFromId(currFacilityID));
                    allFacilityApiData.add(currFacility);
                    handler.postDelayed(() -> {
                        if (totalCalls == facilityIdsFromLine.size()) {
                            runOnUiThread(() -> {
                                try {
                                    binding.facilityItemsRecycler.setLayoutManager(new LinearLayoutManager(this));
                                    final FacilityAdapter facilityAdapter = new FacilityAdapter(allFacilityApiData);
                                    binding.facilityItemsRecycler.setAdapter(facilityAdapter);
                                    swipeRefreshLayout.setRefreshing(false);
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
}
