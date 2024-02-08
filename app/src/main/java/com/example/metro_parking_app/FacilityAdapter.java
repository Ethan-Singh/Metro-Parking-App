package com.example.metro_parking_app;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.metro_parking_app.databinding.FacilityItemRowBinding;

import java.util.ArrayList;

public class FacilityAdapter extends RecyclerView.Adapter<FacilityAdapter.ViewHolder>{

    private final ArrayList<Facility> items;

    public FacilityAdapter(ArrayList<Facility> items){
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new ViewHolder(FacilityItemRowBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Facility item = items.get(position);
        viewHolder.setText(item);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        FacilityItemRowBinding binding;

        public ViewHolder(FacilityItemRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        final FacilityItemRowBinding getBinding() {
            return binding;
        }

        final void setText(Facility item) {
            binding.facilityText.setText(FacilityFormatter.facilityFormat(item));
        }
    }







}