package com.mantra.eyn.ViewAdatpers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mantra.eyn.ClickListeners.MobileClickListener;
import com.mantra.eyn.MobilesResponseClasses.DataMobileClasses;
import com.mantra.eyn.R;
import com.mantra.eyn.ViewHolders.MobileViewHolder;

import java.util.List;

public class MobileViewAdapter extends RecyclerView.Adapter<MobileViewHolder> {

    private List<DataMobileClasses> dataMobileClassesList;
    private MobileClickListener mobileClickListener;

    public MobileViewAdapter(List<DataMobileClasses> dataMobileClassesList, MobileClickListener mobileClickListener) {
        this.dataMobileClassesList = dataMobileClassesList;
        this.mobileClickListener = mobileClickListener;
    }

    @NonNull
    @Override
    public MobileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse_category_on_click_items, parent, false);
        return new MobileViewHolder(view, mobileClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MobileViewHolder holder, int position) {
        DataMobileClasses dataMobileClasses = dataMobileClassesList.get(position);
        holder.setData(dataMobileClasses);
    }

    @Override
    public int getItemCount() {
        return dataMobileClassesList.size();
    }

    public void updateData(List<DataMobileClasses> dataMobileClasses) {
        this.dataMobileClassesList = dataMobileClasses;
        notifyDataSetChanged();
    }
}
