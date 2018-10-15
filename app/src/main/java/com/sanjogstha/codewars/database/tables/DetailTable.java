package com.sanjogstha.codewars.database.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.sanjogstha.codewars.database.Converters;
import com.sanjogstha.codewars.database.DbConstant;

import java.util.List;

/**
 * Created by sanjogstha on 10/15/18.
 * sanjogshrestha.nepal@gmail.com
 */
@Entity(tableName = DbConstant.DETAIL_TABLE)
@TypeConverters(Converters.class)
public class DetailTable {
    @android.support.annotation.NonNull
    @PrimaryKey
    private String id;
    private String name;
    private String slug;
    private String category;
    private String publishedAt;
    private String approvedAt;
    private String approvedBy, createdBy;
    private String approvedByUrl, createdByUrl;
    private List<String> languages = null;
    private String url;
    private String createdAt;
    private String description;
    private long totalAttempts;
    private long totalCompleted;
    private long totalStars;
    private long voteScore;
    private List<String> tags = null;
    private boolean contributorsWanted;

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

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> list) {
        this.languages = list;
    }

    public String getUrl() {
        return url;
    }

    public String getCreatedAt() {
        return createdAt;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public boolean isContributorsWanted() {
        return contributorsWanted;
    }

    public void setId(@NonNull String id) {
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

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByUrl() {
        return createdByUrl;
    }

    public void setCreatedByUrl(String createdByUrl) {
        this.createdByUrl = createdByUrl;
    }

    public String getApprovedByUrl() {
        return approvedByUrl;
    }

    public void setApprovedByUrl(String approvedByUrl) {
        this.approvedByUrl = approvedByUrl;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public void setTotalStars(long totalStars) {
        this.totalStars = totalStars;
    }

    public void setVoteScore(long voteScore) {
        this.voteScore = voteScore;
    }

    public void setContributorsWanted(boolean contributorsWanted) {
        this.contributorsWanted = contributorsWanted;
    }
}
