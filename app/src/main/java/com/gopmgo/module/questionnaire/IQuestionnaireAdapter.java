package com.gopmgo.module.questionnaire;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;


import com.gopmgo.model.Questionnaire;

import java.util.List;

/**
 * Created by aflah on 01/05/20
 * Email  : aflahtaqiusondha@gmail.com
 * Github : https://github.com/aflahtaqiu
 */

public interface IQuestionnaireAdapter {
    void updateData(List<Questionnaire> data);
    void setContext(Context context);
    void setListener(IQuestAdapterListener listener);
    void setAdapter(RecyclerView recyclerView);
}
