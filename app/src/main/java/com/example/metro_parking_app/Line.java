package com.example.metro_parking_app;

public class Line {

    private int image;
    private int colour;

    public Line(int image, int colour) {
        this.image = image;
        this.colour = colour;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }
}
