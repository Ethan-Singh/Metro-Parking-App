package com.example.metro_parking_app;

public class Line {

    private int image;
    private int colour;

    private int id;

    public Line(int image, int colour, int id) {
        this.image = image;
        this.colour = colour;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
