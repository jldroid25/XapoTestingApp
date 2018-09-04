package com.jldroid25.android.trendingdroidrepo.DataModel;

import com.google.gson.annotations.SerializedName;

public class TrendingReposPojo {

    //Desired Keys from our API needed to build model data List.
    @SerializedName("name")
    private String repoNameTitle;

    @SerializedName("html_url")
    private String url;

    @SerializedName("language")
    private String language;

    @SerializedName("description")
    private String description;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("stargazers_count")
    private Double stargazerCount;

    //Constructor
    public TrendingReposPojo(String repoName, String url, String language,
                             String description, String createdAt,
                             Double stargazerCount) {
        this.repoNameTitle = repoName;
        this.url = url;
        this.language = language;
        this.description = description;
        this.createdAt = createdAt;
        this.stargazerCount = stargazerCount;
    }

    //Getter & Setter
    public String getRepoNameTitle() {
        return repoNameTitle;
    }

    public void setRepoNameTitle(String repoNameTitle) {
        this.repoNameTitle = repoNameTitle;
    }

    public String getUrl() {
        return url;
    }

    public String getLanguage() {
        return language;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Double getStargazerCount() {
        return stargazerCount;
    }
}
