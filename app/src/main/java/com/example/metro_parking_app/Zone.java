package com.example.metro_parking_app;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Zone {
    @JsonProperty("spots")
    private String spots;

    @JsonProperty("zone_id")
    private String zoneID;

    @JsonProperty("occupancy")
    private Occupancy occupancy;

    @JsonProperty("zone_name")
    private String zoneName;

    @JsonProperty("parent_zone_id")
    private String parentZoneID;

    public String getSpots() {
        return spots;
    }

    public void setSpots(String spots) {
        this.spots = spots;
    }

    public String getZoneID() {
        return zoneID;
    }

    public void setZoneID(String zoneID) {
        this.zoneID = zoneID;
    }

    public Occupancy getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(Occupancy occupancy) {
        this.occupancy = occupancy;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getParentZoneID() {
        return parentZoneID;
    }

    public void setParentZoneID(String parentZoneID) {
        this.parentZoneID = parentZoneID;
    }
}
