package com.sanjogstha.codewars.database.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.sanjogstha.codewars.database.Converters;
import com.sanjogstha.codewars.database.DbConstant;

import java.util.List;

/**
 * Created by sanjogstha on 10/10/18.
 * sanjogshrestha.nepal@gmail.com
 */
@Entity(tableName = DbConstant.COMPLETED_TABLE)
@TypeConverters(Converters.class)
public class CompletedTable {
    @android.support.annotation.NonNull
    @PrimaryKey
    private String id;
    private String username;
    private String name;
    private String slug;
    private String completedAt;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
