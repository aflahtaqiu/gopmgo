package com.gopmgo.data.source;

import com.gopmgo.base.IBaseCallback;
import com.gopmgo.model.AntiPattern;

import java.util.List;

public interface IAntiPatternDataSource {
    void getDevAntiPattern(AntiPatternCallback callback);
    void getPmAntiPattern(AntiPatternCallback callback);

    interface AntiPatternCallback extends IBaseCallback<List<AntiPattern>> {}
}