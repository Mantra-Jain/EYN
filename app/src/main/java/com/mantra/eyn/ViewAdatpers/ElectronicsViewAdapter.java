package com.mantra.eyn.ViewAdatpers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mantra.eyn.ClickListeners.ElectronicsClickListener;
import com.mantra.eyn.ElectronicsResponseClasses.DataElectronicClasses;
import com.mantra.eyn.R;
import com.mantra.eyn.ViewHolders.ElectronicsViewHolder;

import java.util.List;

public class ElectronicsViewAdapter extends RecyclerView.Adapter<ElectronicsViewHolder> {
    private List<DataElectronicClasses> dataElectronicClassesList;
    private ElectronicsClickListener electronicsClickListener;

    public ElectronicsViewAdapter(List<DataElectronicClasses> dataElectronicClassesList, ElectronicsClickListener electronicsClickListener) {
        this.dataElectronicClassesList = dataElectronicClassesList;
        this.electronicsClickListener = electronicsClickListener;
    }

    @NonNull
    @Override
    public ElectronicsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse_category_on_click_items, parent, false);
        return new ElectronicsViewHolder(view, electronicsClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ElectronicsViewHolder holder, int position) {
        DataElectronicClasses dataElectronicClasses = dataElectronicClassesList.get(position);
        holder.setData(dataElectronicClasses);

    }

    @Override
    public int getItemCount() {
        return dataElectronicClassesList.size();
    }

    public void updateData(List<DataElectronicClasses> dataElectronicClasses) {
        this.dataElectronicClassesList = dataElectronicClasses;
        notifyDataSetChanged();
    }
}
