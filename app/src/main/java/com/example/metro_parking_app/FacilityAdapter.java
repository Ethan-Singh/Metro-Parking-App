package com.example.metro_parking_app;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
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
        viewHolder.setName(item);
        viewHolder.setAvailableSpots(item);
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

        final void setName(Facility item) {
            binding.facilityName.setText(item.getFacilityName());
        }

        final void setAvailableSpots(Facility item) {
            int spots = Integer.valueOf(item.getSpots());
            int availableSpots = spots - Integer.parseInt(item.getOccupancy().getTotal());
            String text = "Current Parking: " + availableSpots + "/" + spots;

            SpannableString spannableString = new SpannableString(text);
            int slashIndex = text.indexOf("/");
            int textColourAvailableSpotsEmpty = Color.GREEN;
            int textColourAvailableSpotsFull = Color.RED;

            if(availableSpots <= 0){
                spannableString.setSpan(new ForegroundColorSpan(textColourAvailableSpotsFull), 15, slashIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else {
                spannableString.setSpan(new ForegroundColorSpan(textColourAvailableSpotsEmpty), 15, slashIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

            binding.facilityAvailableSpots.setText(spannableString);
        }
    }

}