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
public class AntiPattern {
    @PrimaryKey
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("likelihood")
    private double likelihood;

    @SerializedName("severity")
    private double severity;

    @SerializedName("definition")
    private String definition;
}