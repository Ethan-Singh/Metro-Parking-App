package com.example.metro_parking_app;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class LineList {

    public static List<Integer> getLineList() {
        List<Integer> lineList = new ArrayList<>();
        lineList.add(R.drawable.sydney_metro_line);
        lineList.add(R.drawable.tfnsw_t1);
        lineList.add(R.drawable.tfnsw_t2);
        lineList.add(R.drawable.tfnsw_t3);
        lineList.add(R.drawable.tfnsw_t4);
        lineList.add(R.drawable.tfnsw_t5);
        lineList.add(R.drawable.tfnsw_t6);
        lineList.add(R.drawable.tfnsw_t7);
        lineList.add(R.drawable.tfnsw_t8);
        lineList.add(R.drawable.tfnsw_t9);
        lineList.add(R.drawable.tfnsw_sco);
        lineList.add(R.drawable.tfnsw_ccn);
        lineList.add(R.drawable.sydney_b_line);
        return lineList;
    }

    public static List<Integer> getLineColour(){
        List<Integer> lineList = new ArrayList<>();
        lineList.add(Color.parseColor("#008C94"));
        lineList.add(Color.parseColor("#f6910f"));
        lineList.add(Color.parseColor("#0697d1"));
        lineList.add(Color.parseColor("#f25b18"));
        lineList.add(Color.parseColor("#1e56a8"));
        lineList.add(Color.parseColor("#c41090"));
        lineList.add(Color.parseColor("#4664af"));
        lineList.add(Color.parseColor("#697c8a"));
        lineList.add(Color.parseColor("#0a9649"));
        lineList.add(Color.parseColor("#d21a2d"));
        lineList.add(Color.parseColor("#1e56a8"));
        lineList.add(Color.parseColor("#d01f31"));
        lineList.add(Color.parseColor("#FFB81C"));
        return lineList;
    }


}
