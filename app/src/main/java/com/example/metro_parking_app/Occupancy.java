package com.example.metro_parking_app;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Occupancy {

    @JsonProperty("loop")
    private String loop;

    @JsonProperty("total")
    private String total;

    @JsonProperty("monthlies")
    private String monthlies;

    @JsonProperty("open_gate")
    private String openGate;

    @JsonProperty("transients")
    private String transients;

    @JsonProperty("empty")
    private String empty;

    public String getLoop() {
        return loop;
    }

    public void setLoop(String loop) {
        this.loop = loop;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getMonthlies() {
        return monthlies;
    }

    public void setMonthlies(String monthlies) {
        this.monthlies = monthlies;
    }

    public String getOpenGate() {
        return openGate;
    }

    public void setOpenGate(String openGate) {
        this.openGate = openGate;
    }

    public String getTransients() {
        return transients;
    }

    public void setTransients(String transients) {
        this.transients = transients;
    }

    public String getEmpty() {
        return empty;
    }

}

