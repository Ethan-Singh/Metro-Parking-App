package com.example.metro_parking_app;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.metro_parking_app.databinding.LineItemGridBinding;

import java.util.ArrayList;

public class LineAdapter extends RecyclerView.Adapter<LineAdapter.ViewHolder> {

    private final ArrayList<Line> items;
    private OnClickListener onClickListener;

    public LineAdapter(ArrayList<Line> items) {
        this.items = items;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new ViewHolder(LineItemGridBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {
        Line item = items.get(position);
        viewHolder.setImage(item.getImage());
        viewHolder.setBackground(item.getColour());

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
        return items.size();
    }


    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(int position, Line model);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        LineItemGridBinding binding;

        public ViewHolder(LineItemGridBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        final void setImage(int image) {
            binding.lineImage.setImageResource(image);
        }

        final void setBackground(int background) {
            binding.lineImage.setBackgroundColor(background);
        }
    }


}