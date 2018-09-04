package com.jldroid25.android.trendingdroidrepo.API;

import com.jldroid25.android.trendingdroidrepo.DataModel.GitHubApiRepoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiGithubInterface {

    /* The https://github.com/trending/repos is based on the number of stars a repository received.
    So the goal here is to build the url below to get the desired JSON data.

    https://api.github.com/search/repositories?q=topic:android&sort=stars&order=desc&per_page=100
    */

    //Let's define api's endpoints needed
    @GET("search/repositories")
    Call<GitHubApiRepoResponse> getAndroidTrendingRepos(@Query("q") String lang,
                                                        @Query("sort") String sort,
                                                        @Query("order") String order,
                                                        @Query("per_page") Integer pageNumber);
}