package com.example.metro_parking_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.metro_parking_app.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Toolbar myToolbar = binding.toolbar;
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("");


        final ArrayList<Line> lineList = LineData.getLineData();

        binding.lineItemsList.setLayoutManager(new GridLayoutManager(this, 2));
        final LineAdapter lineAdapter = new LineAdapter(lineList);
        binding.lineItemsList.setAdapter(lineAdapter);

        lineAdapter.setOnClickListener(new LineAdapter.OnClickListener() {
            @Override
            public void onClick(int position, Line model) {
                Intent intent = new Intent(MainActivity.this, FacilityDetailsActivity.class);
                intent.putExtra(NEXT_SCREEN, model);
                startActivity(intent);
            }
        });

    }
    public static final String NEXT_SCREEN = "details_screen";

}
