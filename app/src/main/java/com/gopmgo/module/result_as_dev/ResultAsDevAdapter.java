package com.gopmgo.module.result_as_dev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.gopmgo.databinding.ItemResultBinding;
import com.gopmgo.model.AntiPattern;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by aflah on 02/05/20
 * Email  : aflahtaqiusondha@gmail.com
 * Github : https://github.com/aflahtaqiu
 */
public class ResultAsDevAdapter extends RecyclerView.Adapter<ResultAsDevAdapter.ResultAsPmViewHolder>
        implements IResultAsDevAdapter {

    private Context context;
    private List<AntiPattern> items = new ArrayList<>();
    private IResultDevAdapterListener listener;

    private static ResultAsDevAdapter instance;

    public static ResultAsDevAdapter getInstance() {
        if (instance == null) {
            instance = new ResultAsDevAdapter();
        }
        return instance;
    }

    public void setListener(IResultDevAdapterListener listener) {
        this.listener = listener;
    }

    @Override
    public ResultAsPmViewHolder onCreateViewHolder(ViewGroup parent,
                                                  int viewType) {
        return new ResultAsPmViewHolder(ItemResultBinding
                .inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(ResultAsPmViewHolder holder, int position) {
        AntiPattern item = items.get(position);

        holder.binding.tvAntipatternTitle.setText(item.getName());
        holder.binding.tvDetailAntipattern.setText(item.getDefinition());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(item.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    @Override
    public void updateData(List<AntiPattern> data) {
        this.items.clear();
        this.items.addAll(data);

        notifyDataSetChanged();
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void setAdapter(RecyclerView recyclerView) {
        recyclerView.setAdapter(this);
    }

    class ResultAsPmViewHolder extends RecyclerView.ViewHolder {

        ItemResultBinding binding;

        ResultAsPmViewHolder(ItemResultBinding _binding) {
            super(_binding.getRoot());
            binding = _binding;
        }
    }
}   