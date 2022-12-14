package com.mantra.eyn.ViewAdatpers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mantra.eyn.ClickListeners.MumbaiClickListener;
import com.mantra.eyn.MumbaiResponseClasses.DataMumbaiClasses;
import com.mantra.eyn.R;
import com.mantra.eyn.ViewHolders.MumbaiLocationViewHolder;

import java.util.List;

public class MumbaiViewAdapter extends RecyclerView.Adapter<MumbaiLocationViewHolder> {
    private List<DataMumbaiClasses> dataMumbaiClassesList;
    private MumbaiClickListener mumbaiClickListener;

    public MumbaiViewAdapter(List<DataMumbaiClasses> dataMumbaiClassesList, MumbaiClickListener mumbaiClickListener) {
        this.dataMumbaiClassesList = dataMumbaiClassesList;
        this.mumbaiClickListener = mumbaiClickListener;
    }

    @NonNull
    @Override
    public MumbaiLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_for_mumbai, parent, false);
        return new MumbaiLocationViewHolder(view, mumbaiClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MumbaiLocationViewHolder holder, int position) {
        DataMumbaiClasses dataMumbaiClasses = dataMumbaiClassesList.get(position);
        holder.setData(dataMumbaiClasses);
    }

    @Override
    public int getItemCount() {
        return dataMumbaiClassesList.size();
    }

    public void updateData(List<DataMumbaiClasses> dataMumbaiClasses)
    {
        this.dataMumbaiClassesList = dataMumbaiClasses;
        notifyDataSetChanged();
    }
}
