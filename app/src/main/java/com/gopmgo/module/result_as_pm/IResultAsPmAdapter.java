package com.gopmgo.module.result_as_pm;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.gopmgo.model.AntiPattern;

import java.util.List;

/**
 * Created by aflah on 02/05/20
 * Email  : aflahtaqiusondha@gmail.com
 * Github : https://github.com/aflahtaqiu
 */
public interface IResultAsPmAdapter {
    void updateData(List<AntiPattern> data);
    void setContext(Context context);
//    void setListener(IQuestAdapterListener listener);
    void setAdapter(RecyclerView recyclerView);
}
