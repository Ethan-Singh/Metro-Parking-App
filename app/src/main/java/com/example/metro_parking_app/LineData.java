package com.example.metro_parking_app;

import android.graphics.Color;

import java.util.ArrayList;

public class LineData {
    public static ArrayList<Line> getLineData() {
        ArrayList<Line> lineList = new ArrayList<>();
        lineList.add(new Line((R.drawable.sydney_metro_line), Color.parseColor("#008C94"), "M"));
        lineList.add(new Line (R.drawable.tfnsw_t1, Color.parseColor("#f6910f"), "T1"));
        lineList.add(new Line(R.drawable.tfnsw_t2, Color.parseColor("#0697d1"), "T2"));
        lineList.add(new Line(R.drawable.tfnsw_t3, Color.parseColor("#f25b18"), "T3"));
        lineList.add(new Line(R.drawable.tfnsw_t4, Color.parseColor("#1e56a8"), "T4"));
        lineList.add(new Line(R.drawable.tfnsw_t5, Color.parseColor("#c41090"), "T5"));
        lineList.add(new Line(R.drawable.tfnsw_t6, Color.parseColor("#4664af"), "T6"));
        lineList.add(new Line(R.drawable.tfnsw_t7, Color.parseColor("#697c8a"), "T7"));
        lineList.add(new Line(R.drawable.tfnsw_t8, Color.parseColor("#0a9649"), "T8"));
        lineList.add(new Line(R.drawable.tfnsw_t9, Color.parseColor("#d21a2d"), "T9"));
        lineList.add(new Line(R.drawable.tfnsw_sco, Color.parseColor("#1e56a8"), "SCO"));
        lineList.add(new Line(R.drawable.tfnsw_ccn, Color.parseColor("#d01f31"), "CCN"));
        lineList.add(new Line(R.drawable.sydney_b_line, Color.parseColor("#FFB81C"), "B-line"));
        return lineList;
    }
}
