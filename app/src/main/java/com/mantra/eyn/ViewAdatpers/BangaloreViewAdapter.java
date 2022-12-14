package com.mantra.eyn.ViewAdatpers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mantra.eyn.BangaloreResponseClasses.DataBangaloreClasses;
import com.mantra.eyn.ClickListeners.BangaloreClickListener;
import com.mantra.eyn.R;
import com.mantra.eyn.ViewHolders.BangaloreViewHolder;

import java.util.List;

public class BangaloreViewAdapter extends RecyclerView.Adapter<BangaloreViewHolder> {
    private List<DataBangaloreClasses> dataBangaloreClassesList;
    private BangaloreClickListener bangaloreClickListener;

    public BangaloreViewAdapter(List<DataBangaloreClasses> dataBangaloreClassesList, BangaloreClickListener bangaloreClickListener) {
        this.dataBangaloreClassesList = dataBangaloreClassesList;
        this.bangaloreClickListener = bangaloreClickListener;
    }

    @NonNull
    @Override
    public BangaloreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_for_mumbai,parent,false);
        return new BangaloreViewHolder(view, bangaloreClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BangaloreViewHolder holder, int position) {
        DataBangaloreClasses dataBangaloreClasses = dataBangaloreClassesList.get(position);
        holder.setData(dataBangaloreClasses);
    }

    @Override
    public int getItemCount() {
        return dataBangaloreClassesList.size();
    }

    public void updateData(List<DataBangaloreClasses> dataBangaloreClasses)
    {
        this.dataBangaloreClassesList = dataBangaloreClasses;
        notifyDataSetChanged();
    }
}
