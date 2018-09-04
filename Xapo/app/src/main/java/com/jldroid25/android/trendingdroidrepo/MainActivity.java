package com.jldroid25.android.trendingdroidrepo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jldroid25.android.trendingdroidrepo.API.ApiGithubInterface;
import com.jldroid25.android.trendingdroidrepo.API.GithubApiClient;
import com.jldroid25.android.trendingdroidrepo.DataModel.GitHubApiRepoResponse;
import com.jldroid25.android.trendingdroidrepo.DataModel.TrendingReposPojo;
import com.jldroid25.android.trendingdroidrepo.ReposAdapter.TrendingGithubRepoAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // For LogCat Tag
    private static final String TAG = MainActivity.class.getSimpleName();

    //String Constants to build api url.
    private static String TECH_TOPIC = "topic:android";
    private static String SORTING = "stars";
    private static String ORDERING = "desc";
    private static Integer PAGE_NUM_ITEMS = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting our RecyclerView
        final RecyclerView recyclerView = findViewById(R.id.repos_recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Implement the required Interface call to display the data
        ApiGithubInterface apiGithubInterface =
                GithubApiClient.getRepoClient().create(ApiGithubInterface.class);

        Call<GitHubApiRepoResponse> call = apiGithubInterface.getAndroidTrendingRepos(
                TECH_TOPIC, SORTING, ORDERING, PAGE_NUM_ITEMS);
       /*
        Retrofit will download & parse the API data on a background thread,
        and then return the results back to the UI thread via the onResponse
        or onFailure method.
        */

        call.enqueue(new Callback<GitHubApiRepoResponse>() {
            @Override
            public void onResponse(Call<GitHubApiRepoResponse> call,
                                   Response<GitHubApiRepoResponse> response) {

                int statusCode = response.code();

                List<TrendingReposPojo> trendingReposPojos = response.body().getItems();

                //Setting up the recyclerView & Adapter
                recyclerView.setAdapter(new TrendingGithubRepoAdapter(trendingReposPojos,
                        R.layout.repo_list_items, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<GitHubApiRepoResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }// end onCreate
}// end class