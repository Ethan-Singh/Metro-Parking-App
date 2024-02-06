package com.example.metro_parking_app;

import java.util.List;
import java.util.Locale;

public class FacilityFormatter {
    public static String format(Facility facility) {
        StringBuilder formattedString = new StringBuilder();
        String facilityName = facility.getFacilityName();
        String totalSpots = facility.getSpots();
        String occupancy = facility.getOccupancy().getTotal();

        // check the strings are not null
        int availableSpots = 0;
        if (totalSpots != null && occupancy != null) {
            try {
                availableSpots = Integer.parseInt(totalSpots) - Integer.parseInt(occupancy);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        formattedString.append(String.format(Locale.getDefault(), "%s\nAvailable Spots: %d\nTotal Spots: %s\n\n",
                facilityName, availableSpots, totalSpots));

        List<Zone> zones = facility.getZones();
        for (Zone zone : zones) {
            totalSpots = zone.getSpots();
            occupancy = zone.getOccupancy().getTotal();

            // check the strings are not null
            availableSpots = 0;
            if (totalSpots != null && occupancy != null) {
                try {
                    availableSpots = Integer.parseInt(totalSpots) - Integer.parseInt(occupancy);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            formattedString.append(String.format(Locale.getDefault(), "\t%s\n\tAvailable Spots: %d\n\tTotal Spots: %s\n\n",
                    zone.getZoneName(), availableSpots, totalSpots));
        }
        return formattedString.toString();
    }
}
