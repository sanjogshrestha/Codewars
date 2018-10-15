package com.sanjogstha.codewars.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class ChallengeDetailDTO {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;
    @SerializedName("approvedAt")
    @Expose
    private String approvedAt;
    @SerializedName("languages")
    @Expose
    private List<String> languages = null;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("rank")
    @Expose
    private Rank rank;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("createdBy")
    @Expose
    private CreatedBy createdBy;
    @SerializedName("approvedBy")
    @Expose
    private ApprovedBy approvedBy;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("totalAttempts")
    @Expose
    private long totalAttempts;
    @SerializedName("totalCompleted")
    @Expose
    private long totalCompleted;
    @SerializedName("totalStars")
    @Expose
    private long totalStars;
    @SerializedName("voteScore")
    @Expose
    private long voteScore;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("contributorsWanted")
    @Expose
    private boolean contributorsWanted;
    @SerializedName("unresolved")
    @Expose
    private Unresolved unresolved;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getCategory() {
        return category;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getApprovedAt() {
        return approvedAt;
    }

    public String getUrl() {
        return url;
    }

    public Rank getRank() {
        return rank;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    public ApprovedBy getApprovedBy() {
        return approvedBy;
    }

    public String getDescription() {
        return description;
    }

    public long getTotalAttempts() {
        return totalAttempts;
    }

    public long getTotalCompleted() {
        return totalCompleted;
    }

    public long getTotalStars() {
        return totalStars;
    }

    public long getVoteScore() {
        return voteScore;
    }

    public boolean isContributorsWanted() {
        return contributorsWanted;
    }

    public Unresolved getUnresolved() {
        return unresolved;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setApprovedAt(String approvedAt) {
        this.approvedAt = approvedAt;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    public void setApprovedBy(ApprovedBy approvedBy) {
        this.approvedBy = approvedBy;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTotalAttempts(long totalAttempts) {
        this.totalAttempts = totalAttempts;
    }

    public void setTotalCompleted(long totalCompleted) {
        this.totalCompleted = totalCompleted;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public class Unresolved {
        @SerializedName("issues")
        @Expose
        private long issues;
        @SerializedName("suggestions")
        @Expose
        private long suggestions;

        public long getIssues() {
            return issues;
        }

        public long getSuggestions() {
            return suggestions;
        }
    }
    public class Rank {
        @SerializedName("id")
        @Expose
        private long id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("color")
        @Expose
        private String color;

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getColor() {
            return color;
        }
    }
    public class ApprovedBy {
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("url")
        @Expose
        private String url;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
    public class CreatedBy {
        @SerializedName("username")
        @Expose
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}

