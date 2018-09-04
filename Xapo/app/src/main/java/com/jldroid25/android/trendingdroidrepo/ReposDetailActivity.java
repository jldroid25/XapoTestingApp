package com.jldroid25.android.trendingdroidrepo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReposDetailActivity extends AppCompatActivity {

    private static final String GET_TITLE = "repoTitle";
    private static final String GET_URL = "repoUrl";
    private static final String GET_DESC = "repoDescription";
    private static final String GET_DATE= "repoDate";
    private static final String GET_LANG= "repoLanguage";
    private static final String GET_STARS_COUNT= "repoStarCount";

    @BindView(R.id.titleId)
    TextView detailRepoTitle;
    @BindView(R.id.urlId)
    TextView detailRepoUrl;
    @BindView(R.id.descriptionId)
    TextView detailRepoDesc;
    @BindView(R.id.dateId)
    TextView detailRepoDate;
    @BindView(R.id.languageId)
    TextView detailRepoLang;
    @BindView(R.id.numberStarsId)
    TextView detailRepoStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos_details);

        //For Back button <--
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Binding our views with ButterKnife
        ButterKnife.bind(this);

        //Call our intent method to display the extras
        getTrendingGithubRepoDetailsIntent();
    }

    //Menu/For back button <--
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
            return super.onOptionsItemSelected(item);
    }

    private void getTrendingGithubRepoDetailsIntent() {
        //Check if intent has Extras first before trying to retrieve them.
        if (getIntent().hasExtra(GET_TITLE) && getIntent().hasExtra(GET_URL) &&
                getIntent().hasExtra(GET_DESC) && getIntent().hasExtra(GET_DATE) &&
                getIntent().hasExtra(GET_LANG) && getIntent().hasExtra(GET_STARS_COUNT)) {

            final String title = getIntent().getStringExtra(GET_TITLE);
            final String url = getIntent().getStringExtra(GET_URL);
            final String description = getIntent().getStringExtra(GET_DESC);
                  String date = getIntent().getStringExtra(GET_DATE)
                          .replace("T", "\nTime: \t").trim()
                          .replace("Z", "").trim();
            final String language = getIntent().getStringExtra(GET_LANG);
            final String stars = getIntent().getStringExtra(GET_STARS_COUNT);

            //Calling setDetailRepodata()
            setDetailRepoData(title, url,description, date, language, stars );
        }
    }
        private void setDetailRepoData (String title, String url, String description,
                                        String date, String language, String stars ){
            //Assign Data to the Views
            detailRepoTitle.setText(title);
            detailRepoUrl.setText(url);
            detailRepoDesc.setText(description);
            detailRepoDate.setText(date);
            detailRepoLang.setText(language);
            detailRepoStars.setText(stars);
    }
}