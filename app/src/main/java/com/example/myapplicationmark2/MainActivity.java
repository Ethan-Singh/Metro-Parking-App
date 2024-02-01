package com.example.myapplicationmark2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private final String apikey = "apikey [your apikey]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.transport.nsw.gov.au/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CarparkApi carparkApi = retrofit.create(CarparkApi.class);

        Call<List<Facility>> call = carparkApi.getFacilities(apikey);

        call.enqueue(new Callback<List<Facility>>() {
            @Override
            public void onResponse(Call<List<Facility>> call, Response<List<Facility>> response) {

                if(!response.isSuccessful()){
                    try {
                        textViewResult.setText("Code: " + response.code() + "\n"
                                + response.errorBody().string());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    return;
                }

                List<Facility> facilities = response.body();

                for (Facility facility: facilities){
                    String content ="";
                    content += "ID: " + facility.getFacility_id() + "\n";
                    content += "Facility Name: " + facility.getFacility_name() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Facility>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });



    }
}