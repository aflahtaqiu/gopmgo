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
public class Questionnaire {
    @PrimaryKey
    @SerializedName("id")
    private int id;

    @SerializedName("identification")
    private String identification;
}