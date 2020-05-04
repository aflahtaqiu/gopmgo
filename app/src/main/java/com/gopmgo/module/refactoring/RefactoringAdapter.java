package com.gopmgo.module.refactoring;

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
public class RefactoringAdapter extends RecyclerView.Adapter<RefactoringAdapter.RefactoringViewHolder> implements IRefactoringAdapter {

    private Context context;
    private List<AntiPatternSolution> items = new ArrayList<>();

    @Override
    public RefactoringViewHolder onCreateViewHolder(ViewGroup parent,
                                                int viewType) {

        return new RefactoringViewHolder(ItemDetailAntipatternBinding
                .inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(RefactoringViewHolder holder, int position) {
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

    class RefactoringViewHolder extends RecyclerView.ViewHolder {

        ItemDetailAntipatternBinding binding;

        RefactoringViewHolder(ItemDetailAntipatternBinding _binding) {
            super(_binding.getRoot());
            binding =_binding;
        }
    }
}   