package com.sanjogstha.codewars.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sanjogstha on 10/10/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class CodeChallengesDTO {
    @SerializedName("totalAuthored")
    @Expose
    private long totalAuthored;
    @SerializedName("totalCompleted")
    @Expose
    private long totalCompleted;

    public long getTotalAuthored() {
        return totalAuthored;
    }

    public void setTotalAuthored(long totalAuthored) {
        this.totalAuthored = totalAuthored;
    }

    public long getTotalCompleted() {
        return totalCompleted;
    }

    public void setTotalCompleted(long totalCompleted) {
        this.totalCompleted = totalCompleted;
    }
}
