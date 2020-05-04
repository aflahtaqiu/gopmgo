package com.gopmgo.module.refactoring;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.gopmgo.model.AntiPatternSolution;

import java.util.List;

/**
 * Created by aflah on 04/05/20
 * Email  : aflahtaqiusondha@gmail.com
 * Github : https://github.com/aflahtaqiu
 */
public interface IRefactoringAdapter {
    void updateData(List<AntiPatternSolution> data);
    void setContext(Context context);
    void setAdapter(RecyclerView recyclerView);
}
