package com.example.metro_parking_app;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Facility {
    @JsonProperty("tsn")
    private String tsn;

    @JsonProperty("time")
    private String time;

    @JsonProperty("spots")
    private String spots;

    @JsonProperty("zones")
    private List<Zone> zones;

    @JsonProperty("ParkID")
    private String parkID;

    @JsonProperty("occupancy")
    private Occupancy occupancy;

    @JsonProperty("MessageDate")
    private String messageDate;

    @JsonProperty("facility_id")
    private String facilityID;

    @JsonProperty("facility_name")
    private String facilityName;

    @JsonProperty("tfnsw_facility_id")
    private String tfnswFacilityID;

    private String line;

    public String getTsn() {
        return tsn;
    }

    public void setTsn(String tsn) {
        this.tsn = tsn;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSpots() {
        return spots;
    }

    public void setSpots(String spots) {
        this.spots = spots;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    public String getParkID() {
        return parkID;
    }

    public void setParkID(String parkID) {
        this.parkID = parkID;
    }

    public Occupancy getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(Occupancy occupancy) {
        this.occupancy = occupancy;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public String getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(String facilityID) {
        this.facilityID = facilityID;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getTfnswFacilityID() {
        return tfnswFacilityID;
    }

    public void setTfnswFacilityID(String tfnswFacilityID) {
        this.tfnswFacilityID = tfnswFacilityID;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }


}
