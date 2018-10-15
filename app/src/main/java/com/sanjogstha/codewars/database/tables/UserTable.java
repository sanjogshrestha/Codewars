package com.sanjogstha.codewars.database.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.sanjogstha.codewars.database.DbConstant;

/**
 * Created by sanjogstha on 10/10/18.
 * sanjogshrestha.nepal@gmail.com
 */
@Entity(tableName = DbConstant.USER_TABLE)
public class UserTable {
    @NonNull
    @PrimaryKey private String username;
    private String name;
    private long honor;
    private String clan;
    private long leaderboardPosition;
    private long totalAuthored;
    private long totalCompleted;
    private long rank;
    private String color;
    private long score;

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHonor() {
        return honor;
    }

    public void setHonor(long honor) {
        this.honor = honor;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public long getLeaderboardPosition() {
        return leaderboardPosition;
    }

    public void setLeaderboardPosition(long leaderboardPosition) {
        this.leaderboardPosition = leaderboardPosition;
    }
}
