package com.jldroid25.android.trendingdroidrepo.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//This client class uses the Retrofit Builder to specify the base URL & send the Network Request.
public class GithubApiClient {

    public static final String BASE_GITHUB_API_URL = "https://api.github.com/";

    private static Retrofit githubRepoRetrofit = null;

    public static Retrofit getRepoClient() {
        if (githubRepoRetrofit == null) {
            githubRepoRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_GITHUB_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return githubRepoRetrofit;
    }
}