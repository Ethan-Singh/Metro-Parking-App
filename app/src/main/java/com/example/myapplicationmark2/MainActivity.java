package com.example.myapplicationmark2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;

    //need to make this more secure - relative path maybe, use .gitignore for a local .txtfile?
    private final String apiKey = "apikey [your apiKey]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);

        //uses an executor to complete an asynchronous network call
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            //network call
            String result = ApiRequest();
            //return 'result's on main thread
            runOnUiThread(() -> textViewResult.setText(result));
        });
    }

    private String ApiRequest() {
        try {
            //initialise the URL
            URL url = new URL("https://api.transport.nsw.gov.au/v1/carpark?facility=1");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("Authorization", apiKey);
                urlConnection.setRequestProperty("Content-Type", "application/json");

                int response = urlConnection.getResponseCode();
                if (response == HttpURLConnection.HTTP_OK) {
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    return convertInputStreamToString(in);
                } else {
                    InputStream errorStream = new BufferedInputStream(urlConnection.getErrorStream());
                    return "Error response: " + convertInputStreamToString(errorStream);
                }

            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    private String convertInputStreamToString(InputStream inputStream) {
        java.util.Scanner s = new java.util.Scanner(inputStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}