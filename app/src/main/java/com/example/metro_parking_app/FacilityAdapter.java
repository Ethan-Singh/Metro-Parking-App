package com.example.metro_parking_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FacilityAdapter extends RecyclerView.Adapter<FacilityAdapter.ViewHolder>{

    private final FacilityList facilityList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);

            textView = view.findViewById(R.id.textViewFacilityItem);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public FacilityAdapter(FacilityList facilityList){
        this.facilityList = facilityList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.facility_item, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Facility facility = facilityList.getFacilityList().get(position);
        String formattedFacilityData = FacilityFormatter.facilityFormat(facility);
        viewHolder.getTextView().setText(formattedFacilityData);
    }

    @Override
    public int getItemCount() {
        return facilityList.getFacilityList().size();
    }
}