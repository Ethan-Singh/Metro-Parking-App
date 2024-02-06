package com.example.metro_parking_app;

import java.util.List;

public class FacilityFormatter {
    public static String format(Facility facility){
        StringBuilder formattedString = new StringBuilder();
        String facilityName = facility.getFacilityName();
        String totalSpots = facility.getSpots();
        String occupancy = facility.getOccupancy().getTotal();
        int availableSpots = Integer.parseInt(totalSpots) - Integer.parseInt(occupancy);

        formattedString.append("Facility Name: ").append(facilityName)
                .append("\nAvaialable Spots: ").append(availableSpots)
                .append("\nTotal Spots: ").append(totalSpots)
                .append("\n\nParking Bays:");

        List<Zone> zones = facility.getZones();
        for (Zone zone : zones) {
            totalSpots = zone.getSpots();
            occupancy = zone.getOccupancy().getTotal();
            availableSpots = Integer.parseInt(totalSpots) - Integer.parseInt(occupancy);

            formattedString.append("\n").append(zone.getZoneName())
                    .append("\n  Available Spots: ").append(availableSpots)
                    .append("\n  Total Spots: ").append(totalSpots).append("\n");
        }
        return formattedString.toString();
    }
}
