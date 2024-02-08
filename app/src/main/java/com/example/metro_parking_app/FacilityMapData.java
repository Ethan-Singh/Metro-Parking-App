package com.example.metro_parking_app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacilityMapData {

    Map<String, List<String>> facilityMap;

    public FacilityMapData() {
        facilityMap = new HashMap<>();
        facilityMap.put("M", Arrays.asList("26", "27", "28", "29", "30", "31", "32", "33"));
        facilityMap.put("T1", Arrays.asList("24", "21", "22", "18"));
        facilityMap.put("T2", Arrays.asList("486"));
        facilityMap.put("T4", Arrays.asList("15", "487"));
        facilityMap.put("T5", Arrays.asList("488", "16", "17", "23"));
        facilityMap.put("T8", Arrays.asList("19", "20", "9"));
        facilityMap.put("T9", Arrays.asList("25", "6", "14"));
        facilityMap.put("SCO", Arrays.asList("7"));
        facilityMap.put("CCN", Arrays.asList("8"));
        facilityMap.put("B-Line", Arrays.asList("10", "11", "12", "13", "490", "489"));
    }

    //for debugging
    public List<String> getAllFacilityIds() {
        List<String> allFacilityIds = new ArrayList<>();
        for (List<String> facilityIds : facilityMap.values()) {
            allFacilityIds.addAll(facilityIds);
        }
        return allFacilityIds;
    }

    public String getLineFromId(String val){
        for(Map.Entry<String, List<String>> entry: facilityMap.entrySet()){
            if(entry.getValue().contains(val)){
                return entry.getKey();
            }
        }
        System.err.println("Key is not found");
        return null;
    }

    public List<String> getFacilityIdsFromLine(String line) {
        List<String> facilityIds = facilityMap.get(line);

        if (facilityIds == null) {
            throw new IllegalArgumentException("Facility IDs for the given line are null");
        }

        return new ArrayList<>(facilityIds);
    }


}
