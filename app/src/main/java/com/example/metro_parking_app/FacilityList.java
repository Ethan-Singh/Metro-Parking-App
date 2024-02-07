package com.example.metro_parking_app;

import java.util.ArrayList;
import java.util.List;

public class FacilityList {
    private final List<Facility> facilityList;

    public FacilityList() {
        facilityList = new ArrayList<>();
    }

    public List<Facility> getList() {
        return facilityList;
    }

    public void addFacility(Facility facility){
        facilityList.add(facility);
    }

}
