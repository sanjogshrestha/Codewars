package com.sanjogstha.codewars.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sanjogstha on 10/10/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class CompletedChallengeDataDTO {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("completedAt")
    @Expose
    private String completedAt;
    @SerializedName("completedLanguages")
    @Expose
    private List<String> completedLanguages = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(String completedAt) {
        this.completedAt = completedAt;
    }

    public List<String> getCompletedLanguages() {
        return completedLanguages;
    }

    public void setCompletedLanguages(List<String> completedLanguages) {
        this.completedLanguages = completedLanguages;
    }
}
