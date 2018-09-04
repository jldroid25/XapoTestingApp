package com.jldroid25.android.trendingdroidrepo.DataModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

//Class to contain all the fetch GitHub Repos "items" from the api response.
public class GitHubApiRepoResponse {

    @SerializedName("items")
    private List<TrendingReposPojo> items;

    public List<TrendingReposPojo> getItems() {
        return items;
    }
}