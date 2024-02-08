package com.example.metro_parking_app;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LineAdapter extends RecyclerView.Adapter<LineAdapter.ViewHolder>{

    private final LineList lineList;



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

    public LineAdapter(LineList lineList){
        this.lineList = lineList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.line_item, viewGroup,false);
        return new ViewHolder(view);
    }

    //edit me to edit the cards
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        int listImage = lineList.getLineList().get(position).getImage();
        int listColour = lineList.getLineList().get(position).getColour();
        viewHolder.getImageView().setImageResource(listImage);
        viewHolder.getImageView().setBackgroundColor(listColour);
    }

    @Override
    public int getItemCount() {
        return lineList.getLineList().size();
    }

}