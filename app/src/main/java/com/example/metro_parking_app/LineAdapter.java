package com.example.metro_parking_app;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LineAdapter extends RecyclerView.Adapter<LineAdapter.ViewHolder>{

    private final List<Integer> lineList;
    private final List<Integer> lineColour;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;

        public ViewHolder(View view) {
            super(view);

            imageView = view.findViewById(R.id.imageViewLineItem);
        }

        public ImageView getImageView() {
            return imageView;
        }
    }

    public LineAdapter(List<Integer> lineList, List<Integer> lineColour){
        this.lineList = lineList;
        this.lineColour = lineColour;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.line_item, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Integer listImage = lineList.get(position);
        Integer listColour = lineColour.get(position);
        viewHolder.getImageView().setImageResource(listImage);
        viewHolder.getImageView().setBackgroundColor(listColour);
    }

    @Override
    public int getItemCount() {
        return lineList.size();
    }

}