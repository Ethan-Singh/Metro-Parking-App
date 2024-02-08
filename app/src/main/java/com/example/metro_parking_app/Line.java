package com.example.metro_parking_app;

import java.io.Serializable;

public class Line implements Serializable {

    private final int image;
    private final int colour;

    private final String id;

    public Line(int image, int colour, String id) {
        this.image = image;
        this.colour = colour;
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public int getColour() {
        return colour;
    }

    public String getId() {
        return id;
    }
}
