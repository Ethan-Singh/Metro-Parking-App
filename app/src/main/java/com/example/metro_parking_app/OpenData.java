package com.example.metro_parking_app;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenData {

    private String apiKey;
    private final AppCompatActivity activity;

    public OpenData(AppCompatActivity activity) {
        this.activity = activity;
    }

    public void readApiKey() {
        try (InputStream myKey = activity.getAssets().open("myKey.txt");
             InputStream key = activity.getAssets().open("key.txt")) {

            InputStream selectedStream = (myKey != null) ? myKey : key;

            if (selectedStream != null) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(selectedStream))) {
                    apiKey = br.readLine();
                    return;
                }
            }

            System.err.println("ERROR. NO_API_KEY_FOUND. Please input your API key in the app/src/main/assets/key.txt file");
        } catch (IOException e) {
            e.printStackTrace(); // You might want to log the exception or handle it appropriately.
        }
    }

    private String convertInputStreamToString(InputStream inputStream) {
        java.util.Scanner s = new java.util.Scanner(inputStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    private Facility parseFacility(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(json, Facility.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String CarParkAPI() {
        try {
            // Initialize the URL
            URL url = new URL("https://api.transport.nsw.gov.au/v1/carpark?facility=1");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("Authorization", apiKey);
                urlConnection.setRequestProperty("Content-Type", "application/json");

                int response = urlConnection.getResponseCode();
                if (response == HttpURLConnection.HTTP_OK) {
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    Facility facility = parseFacility(convertInputStreamToString(in));

                    if (facility != null) {
                        System.out.println(facility.getSpots());
                        return "It workssss!!!";
                    } else {
                        return "Facility object is null";
                    }
                } else {
                    InputStream errorStream = new BufferedInputStream(urlConnection.getErrorStream());
                    return "Error response: " + convertInputStreamToString(errorStream);
                }

            } finally {
                urlConnection.disconnect();
            }
        } catch (IOException e) {
            Log.e("YourClass", "Error reading from the network", e);
            return "Error reading from the network: " + e.getMessage();
        }
    }

}
