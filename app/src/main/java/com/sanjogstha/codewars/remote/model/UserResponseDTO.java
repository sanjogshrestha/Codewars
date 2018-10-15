package com.sanjogstha.codewars.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sanjogstha on 10/10/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class UserResponseDTO {
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("honor")
    @Expose
    private long honor;
    @SerializedName("clan")
    @Expose
    private String clan;
    @SerializedName("leaderboardPosition")
    @Expose
    private long leaderboardPosition;
    @SerializedName("ranks")
    @Expose
    private RanksDTO ranks;
    @SerializedName("codeChallenges")
    @Expose
    private CodeChallengesDTO codeChallenges;

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

    public RanksDTO getRanks() {
        return ranks;
    }

    public void setRanks(RanksDTO ranks) {
        this.ranks = ranks;
    }

    public CodeChallengesDTO getCodeChallenges() {
        return codeChallenges;
    }

    public void setCodeChallenges(CodeChallengesDTO codeChallenges) {
        this.codeChallenges = codeChallenges;
    }
}
