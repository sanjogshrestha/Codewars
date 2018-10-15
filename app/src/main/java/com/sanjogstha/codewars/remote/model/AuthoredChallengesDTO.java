package com.sanjogstha.codewars.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sanjogstha on 10/11/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class AuthoredChallengesDTO {
    @SerializedName("data")
    @Expose
    private List<AuthoredChallengesDataDTO> data = null;

    public List<AuthoredChallengesDataDTO> getData() {
        return data;
    }

    public void setData(List<AuthoredChallengesDataDTO> data) {
        this.data = data;
    }
}
