package com.gopmgo.data.source;

import com.gopmgo.base.IBaseCallback;
import com.gopmgo.model.AntiPatternSolution;

import java.util.List;

public interface IAntiPatternSolutionDataSource {

    void getBandAids(SolutionCallback callback);
    void getSelfRepairs(SolutionCallback callback);
    void getRefactorings(SolutionCallback callback);

    interface SolutionCallback extends IBaseCallback<List<AntiPatternSolution>> {}
}