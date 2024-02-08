package com.example.metro_parking_app;

import java.util.ArrayList;
import java.util.List;

public class LineList {

    private final List<Line> lineList;

    public LineList() {
        lineList = new ArrayList<>();
    }

    public List<Line> getLineList() {
        return lineList;
    }

    public void addLine (Line line) {
        lineList.add(line);
    }

}
