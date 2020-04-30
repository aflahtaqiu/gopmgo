package com.gopmgo.model;

import androidx.room.Entity;
import androidx.room.Ignore;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by aflah on 30/04/20
 * Email  : aflahtaqiusondha@gmail.com
 * Github : https://github.com/aflahtaqiu
 */

@AllArgsConstructor(onConstructor = @__({@Ignore}))
@Builder
@Data
@NoArgsConstructor
public class RefactoredSolution {

    @SerializedName("id_category")
    private int idCategory;

    @SerializedName("refactored_solution")
    private String refactoredSolution;
}
