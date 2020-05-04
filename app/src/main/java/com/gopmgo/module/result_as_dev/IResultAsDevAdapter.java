package com.gopmgo.module.result_as_dev;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.gopmgo.model.AntiPattern;

import java.util.List;

/**
 * Created by aflah on 04/05/20
 * Email  : aflahtaqiusondha@gmail.com
 * Github : https://github.com/aflahtaqiu
 */
public interface IResultAsDevAdapter {
    void updateData(List<AntiPattern> data);
    void setContext(Context context);
    void setListener(IResultDevAdapterListener listener);
    void setAdapter(RecyclerView recyclerView);
}
