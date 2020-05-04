package com.gopmgo.module.band_aid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.gopmgo.databinding.ItemDetailAntipatternBinding;
import com.gopmgo.model.AntiPatternSolution;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by aflah on 04/05/20
 * Email  : aflahtaqiusondha@gmail.com
 * Github : https://github.com/aflahtaqiu
 */
public class BandAidAdapter extends RecyclerView.Adapter<BandAidAdapter.BandAidViewHolder> implements IBandAidAdapter {

    private Context context;
    private List<AntiPatternSolution> items = new ArrayList<>();

    @Override
    public BandAidViewHolder onCreateViewHolder(ViewGroup parent,
                                                int viewType) {

        return new BandAidViewHolder(ItemDetailAntipatternBinding
                .inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(BandAidViewHolder holder, int position) {
        AntiPatternSolution item = items.get(position);

        int number = position+1;
        holder.binding.tvNumber.setText(number+".");
        holder.binding.tvSolution.setText(item.getSolution().getRefactoredSolution());
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    @Override
    public void updateData(List<AntiPatternSolution> data) {
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

    class BandAidViewHolder extends RecyclerView.ViewHolder {

        ItemDetailAntipatternBinding binding;

        BandAidViewHolder(ItemDetailAntipatternBinding _binding) {
            super(_binding.getRoot());
            binding =_binding;
        }
    }
}   