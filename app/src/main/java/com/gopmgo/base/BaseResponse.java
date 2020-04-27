package com.gopmgo.base;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class BaseResponse<T> {

    @SerializedName("code")
    private int code;

    @SerializedName("status")
    private String status;

    @SerializedName("data")
    private T data;

    @SerializedName("paging")
    private List<ResponsePaging> pagings;

    @SerializedName("errors")
    private Map<String, List<String>> errors;
}