package com.mantra.eyn.ViewAdatpers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mantra.eyn.ClickListeners.JobClickListener;
import com.mantra.eyn.JobsReponseClasses.DataJobClasses;
import com.mantra.eyn.R;
import com.mantra.eyn.ViewHolders.JobsViewHolder;

import java.util.List;

public class JobsViewAdapter extends RecyclerView.Adapter<JobsViewHolder> {
    private List<DataJobClasses> dataJobClassesList;
    private JobClickListener jobClickListener;

    public JobsViewAdapter(List<DataJobClasses> dataJobClassesList, JobClickListener jobClickListener) {
        this.dataJobClassesList = dataJobClassesList;
        this.jobClickListener = jobClickListener;
    }

    @NonNull
    @Override
    public JobsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse_category_on_click_items, parent, false);
        return new JobsViewHolder(view, jobClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull JobsViewHolder holder, int position) {
        DataJobClasses dataJobClasses = dataJobClassesList.get(position);
        holder.setData(dataJobClasses);
    }

    @Override
    public int getItemCount() {
        return dataJobClassesList.size();
    }

    public void updateData(List<DataJobClasses> dataJobClasses) {
        this.dataJobClassesList = dataJobClasses;
        notifyDataSetChanged();
    }
}
