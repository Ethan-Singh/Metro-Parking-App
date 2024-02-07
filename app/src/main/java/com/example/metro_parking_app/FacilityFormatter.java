package com.example.metro_parking_app;

import java.util.Locale;

public class FacilityFormatter {
    public static String format(Facility facility) {
        StringBuilder formattedString = new StringBuilder();
        String facilityName = facility.getFacilityName();
        String facilitySpots = facility.getSpots();
        String facilityOccupancy = facility.getOccupancy().getTotal();

        int facilityAvailableSpots = 0;
        // check the strings are not null
        if (facilitySpots != null && facilityOccupancy != null) {
            try {
                facilityAvailableSpots = Integer.parseInt(facilitySpots) - Integer.parseInt(facilityOccupancy);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        formattedString.append(String.format(Locale.getDefault(), "%s\nAvailable Spots: %d\nTotal Spots: %s\n\n",
                facilityName, facilityAvailableSpots, facilitySpots));

        return formattedString.toString();
    }
}
