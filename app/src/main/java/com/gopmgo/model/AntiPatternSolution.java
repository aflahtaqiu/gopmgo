package com.gopmgo.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(onConstructor = @__({@Ignore}))
@Builder
@Data
@Entity
@NoArgsConstructor
public class AntiPatternSolution {
    @PrimaryKey
    @SerializedName("id_antipattern")
    private int idAntiPattern;

    @SerializedName("solution")
    private RefactoredSolution solution;
}