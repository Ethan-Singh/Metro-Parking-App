package com.example.metro_parking_app;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LineAdapter extends RecyclerView.Adapter<LineAdapter.ViewHolder>{

    public interface OnClickListener {
        void onClick(int position, Line item);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    private final LineList lineList;
    private OnClickListener onClickListener;

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
    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {
        Line item = lineList.getLineList().get(position);
        int listImage = lineList.getLineList().get(position).getImage();
        int listColour = lineList.getLineList().get(position).getColour();
        viewHolder.getImageView().setImageResource(listImage);
        viewHolder.getImageView().setBackgroundColor(listColour);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(position, item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lineList.getLineList().size();
    }



}