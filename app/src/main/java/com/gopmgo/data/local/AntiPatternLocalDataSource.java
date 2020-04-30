package com.gopmgo.data.local;

import android.content.Context;

import com.gopmgo.data.source.IAntiPatternDataSource;
import com.gopmgo.model.AntiPattern;

public class AntiPatternLocalDataSource implements IAntiPatternDataSource {

    private Context context;

    public AntiPatternLocalDataSource(Context context) {
        this.context = context;
    }

    @Override
    public void getDevAntiPattern(AntiPatternCallback callback) {

    }

    @Override
    public void getPmAntiPattern(AntiPatternCallback callback) {

    }
}