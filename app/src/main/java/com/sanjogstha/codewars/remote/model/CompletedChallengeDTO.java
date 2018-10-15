package com.sanjogstha.codewars.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sanjogstha on 10/10/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class CompletedChallengeDTO {
    @SerializedName("totalPages")
    @Expose
    private long totalPages;
    @SerializedName("totalItems")
    @Expose
    private long totalItems;
    @SerializedName("data")
    @Expose
    private List<CompletedChallengeDataDTO> data = null;

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public List<CompletedChallengeDataDTO> getData() {
        return data;
    }

    public void setData(List<CompletedChallengeDataDTO> data) {
        this.data = data;
    }
}
