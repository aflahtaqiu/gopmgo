package com.gopmgo.base;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ResponsePaging {

    @SerializedName("page")
    private Integer page;

    @SerializedName("item_per_page")
    private Integer itemPerPage;

    @SerializedName("last_page")
    private Integer lastPage;

    @SerializedName("total_item")
    private Long totalItem;
}