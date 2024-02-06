package com.example.metro_parking_app;

import java.util.ArrayList;
import java.util.List;

public class FacilityList {
    private final List<Facility> facilityList;

    public FacilityList() {
        facilityList = new ArrayList<>();
    }

    public void addFacility(Facility facility){
        facilityList.add(facility);
    }

    public List<Facility> getList() {
        return new ArrayList<>(facilityList);
    }

}
