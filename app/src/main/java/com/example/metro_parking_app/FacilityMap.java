package com.example.metro_parking_app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacilityMap {
    private final Map<String, List<String>> facilityMap;
    public FacilityMap() {
        facilityMap = new HashMap<>();
        // (M)
        facilityMap.put("M", Arrays.asList("26", "27", "28", "29", "30", "31", "32", "33"));

        // (T1)
        facilityMap.put("T1", Arrays.asList("24", "21", "22", "18"));

        // (T2)
        facilityMap.put("T2", Arrays.asList("486"));

        // (T4)
        facilityMap.put("T4", Arrays.asList("15", "487"));

        // (T5)
        facilityMap.put("T5", Arrays.asList("488", "16", "17", "23"));

        // (T8)
        facilityMap.put("T8", Arrays.asList("19", "20", "9"));

        // (T9)
        facilityMap.put("T9", Arrays.asList("25", "6", "14"));

        // (SCO)
        facilityMap.put("SCO", Arrays.asList("7"));

        // (CCN)
        facilityMap.put("CCN", Arrays.asList("8"));

        // (B-Line)
        facilityMap.put("B-Line", Arrays.asList("10", "11", "12", "13", "490", "489"));
    }

    public List<String> getAllFacilityIds() {
        List<String> allFacilityIds = new ArrayList<>();
        for (List<String> facilityIds : facilityMap.values()) {
            allFacilityIds.addAll(facilityIds);
        }
        return allFacilityIds;
    }
}
