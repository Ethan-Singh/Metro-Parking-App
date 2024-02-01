package com.example.myapplicationmark2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface CarparkApi {
    @GET("carpark/")
    Call<List<Facility>> getFacilities(@Header("Authorization")String apikey);
}
