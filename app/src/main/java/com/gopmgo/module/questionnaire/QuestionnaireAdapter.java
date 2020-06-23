package com.gopmgo.module.questionnaire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.gopmgo.R;
import com.gopmgo.databinding.ItemQuestionnaireBinding;
import com.gopmgo.model.Questionnaire;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aflah on 30/04/20
 * Email  : aflahtaqiusondha@gmail.com
 * Github : https://github.com/aflahtaqiu
 */
public class QuestionnaireAdapter extends RecyclerView.Adapter<QuestionnaireAdapter.QuestionnaireViewHolder>
        implements IQuestionnaireAdapter{

    private Context context;
    private List<Questionnaire> items =  new ArrayList<>();
    private IQuestAdapterListener listener;

    private int selectedAnswer = 0;
    private static final int ZERO_ITEM = 0;
    private static final int FIRST_ANSWER = 1;
    private static final int SECOND_ANSWER = 2;
    private static final int THIRD_ANSWER = 3;
    private static final int FOURTH_ANSWER = 4;
    private static final int FIFTH_ANSWER = 5;

    @Override
    public void setListener(IQuestAdapterListener listener) {
        this.listener = listener;
    }

    @Override
    public void setAdapter(RecyclerView recyclerView) {
        recyclerView.setAdapter(this);
    }

    @Override
    public QuestionnaireViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        return new QuestionnaireViewHolder(ItemQuestionnaireBinding
                .inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(final QuestionnaireViewHolder holder, int position) {
        final Questionnaire item = items.get(position);
        holder.binding.tvQuestionnaire.setText(item.getIdentification());
        holder.binding.radioGroup.clearCheck();

        holder.binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_first : selectedAnswer = FIRST_ANSWER; break;
                    case R.id.rb_second : selectedAnswer = SECOND_ANSWER; break;
                    case R.id.rb_third : selectedAnswer = THIRD_ANSWER; break;
                    case R.id.rb_fourth : selectedAnswer = FOURTH_ANSWER; break;
                    case R.id.rb_fifth : selectedAnswer = FIFTH_ANSWER; break;
                }
                listener.onQuestSelected(item.getId(), selectedAnswer);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return ZERO_ITEM;
        }
        return items.size();
    }

    @Override
    public void updateData(List<Questionnaire> data) {
        this.items.clear();
        this.items.addAll(data);

        notifyDataSetChanged();
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    class QuestionnaireViewHolder extends RecyclerView.ViewHolder {

        ItemQuestionnaireBinding binding;

        QuestionnaireViewHolder(ItemQuestionnaireBinding _binding) {
            super(_binding.getRoot());
            binding = _binding;
        }
    }
}