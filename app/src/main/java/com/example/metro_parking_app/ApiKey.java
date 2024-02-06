package com.example.metro_parking_app;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ApiKey {
    public static String readApiKey(AppCompatActivity activity) {
        try (InputStream myKey = activity.getAssets().open("myKey.txt");
             InputStream key = activity.getAssets().open("key.txt")) {

            InputStream selectedStream = (myKey != null) ? myKey : key;

            if (selectedStream != null) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(selectedStream))) {
                    return br.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.err.println("ERROR. NO_API_KEY_FOUND. Please input your API key in the app/src/main/assets/key.txt file");
        return "NO_API_KEY_FOUND";
    }

}
