package com.gopmgo.module.questionnaire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.gopmgo.databinding.ItemQuestionnaireBinding;

import java.util.List;



/**
 * Created by aflah on 30/04/20
 * Email  : aflahtaqiusondha@gmail.com
 * Github : https://github.com/aflahtaqiu
 */
public class QuestionnaireAdapter extends RecyclerView.Adapter<QuestionnaireAdapter.QuestionnaireViewHolder> {
    private final Context context;
    private List<String> items;

    private IQuestAdapterListener listener;

    public QuestionnaireAdapter(List<String> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public QuestionnaireViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {

        return new QuestionnaireViewHolder(ItemQuestionnaireBinding
                .inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(QuestionnaireViewHolder holder, int position) {
        String item = items.get(position);

        holder.binding.tvQuestionnaire.setText(item);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    class QuestionnaireViewHolder extends RecyclerView.ViewHolder {

        ItemQuestionnaireBinding binding;

        QuestionnaireViewHolder(ItemQuestionnaireBinding _binding) {
            super(_binding.getRoot());
            binding = _binding;
        }
    }

    interface IQuestAdapterListener {
        void onQuestSelected (int value);
    }
}   