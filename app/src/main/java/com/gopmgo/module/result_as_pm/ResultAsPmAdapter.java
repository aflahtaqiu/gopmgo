package com.gopmgo.module.result_as_pm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.gopmgo.R;
import com.gopmgo.databinding.ItemResultBinding;
import com.gopmgo.model.AntiPattern;
import com.hsalf.smilerating.SmileRating;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aflah on 02/05/20
 * Email  : aflahtaqiusondha@gmail.com
 * Github : https://github.com/aflahtaqiu
 */
public class ResultAsPmAdapter extends RecyclerView.Adapter<ResultAsPmAdapter.ResultAsPmViewHolder>
        implements IResultAsPmAdapter {

    private Context context;
    private List<AntiPattern> items = new ArrayList<>();
    private IResultPmAdapterListener listener;
    private static ResultAsPmAdapter instance;

    private static final int ZERO_ITEM = 0;
    private static final int MIN_NORMAL_RATING = 3;
    private static final int INDEX_DECREMENT = 1;
    private static final String RATING_BAR_TITLE = "";

    public static ResultAsPmAdapter getInstance() {
        if (instance == null) {
            instance = new ResultAsPmAdapter();
        }
        return instance;
    }

    @Override
    public void setListener(IResultPmAdapterListener listener) {
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

        hideSmileName(holder.binding.ratingbarLikelihood);
        hideSmileName(holder.binding.ratingbarSeverity);

        int likelihood = (int) Math.round(item.getLikelihood());
        int severity = (int) Math.round(item.getSeverity());

        holder.binding.ratingbarLikelihood.setSelectedSmile(likelihood - INDEX_DECREMENT);
        holder.binding.ratingbarSeverity.setSelectedSmile(severity - INDEX_DECREMENT);

        setRatingbarColor(holder.binding.ratingbarLikelihood);
        setRatingbarColor(holder.binding.ratingbarSeverity);

        holder.binding.tvAntipatternTitle.setText(item.getName());
        holder.binding.tvDetailAntipattern.setText(item.getDefinition());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(item.getId(), item.getName());
            }
        });
    }

    private void hideSmileName (SmileRating smileRating) {
        smileRating.setNameForSmile(SmileRating.TERRIBLE, RATING_BAR_TITLE);
        smileRating.setNameForSmile(SmileRating.BAD, RATING_BAR_TITLE);
        smileRating.setNameForSmile(SmileRating.OKAY, RATING_BAR_TITLE);
        smileRating.setNameForSmile(SmileRating.GOOD, RATING_BAR_TITLE);
        smileRating.setNameForSmile(SmileRating.GREAT, RATING_BAR_TITLE);
    }

    private void setRatingbarColor (SmileRating smileRating) {
        int rating = smileRating.getRating();
        if (rating < MIN_NORMAL_RATING)
            smileRating.setAngryColor(context.getResources().getColor(R.color.yellowEmoji));
        else
            smileRating.setNormalColor(context.getResources().getColor(R.color.orangeEmoji));
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return ZERO_ITEM;
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