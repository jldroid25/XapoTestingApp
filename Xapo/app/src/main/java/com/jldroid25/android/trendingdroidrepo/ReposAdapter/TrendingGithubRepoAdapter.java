package com.jldroid25.android.trendingdroidrepo.ReposAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jldroid25.android.trendingdroidrepo.DataModel.TrendingReposPojo;
import com.jldroid25.android.trendingdroidrepo.R;
import com.jldroid25.android.trendingdroidrepo.ReposDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrendingGithubRepoAdapter extends
        RecyclerView.Adapter<TrendingGithubRepoAdapter.ReposViewHolder> {

    private List<TrendingReposPojo> trendingAndroidRepos;
    private int rowLayout;
    private Context c;

    //Constructor
    public TrendingGithubRepoAdapter(List<TrendingReposPojo> trendingAndroidRepos,
                                     int rowLayout, Context ctx) {
        this.trendingAndroidRepos = trendingAndroidRepos;
        this.rowLayout = rowLayout;
        this.c = ctx;
    }

    //Inner ViewHolder Class for placing our layout & views
    public static class ReposViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ItemClickListener itemClickListener;

        @BindView(R.id.repos_layout_id)
        LinearLayout reposLayout;
        @BindView(R.id.repoNameTitle)
        TextView repoTitle ;
        @BindView(R.id.repoUrl)
        TextView  repoUrl;
        @BindView(R.id.description)
        TextView  repoDescription;
        @BindView(R.id.repoDate)
        TextView repoDate;
        @BindView(R.id.repoLanguage)
        TextView repoLanguage;
        @BindView(R.id.repoStarCount)
        TextView  repoStarCount;

        //Our View parameters
        public ReposViewHolder(View v) {
            super(v);
            //Binding our views with ButterKnife
            ButterKnife.bind(this, v);

            v.setOnClickListener(this);
        }

        //To make RecyclerView ClickAble
        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener itemClickListener2) {
            this.itemClickListener = itemClickListener2;
        }
    }

    @Override
    public TrendingGithubRepoAdapter.ReposViewHolder onCreateViewHolder(ViewGroup parent,
                                                                        int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(rowLayout, parent, false);
        return new ReposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TrendingGithubRepoAdapter.ReposViewHolder holder,
                                 final int position) {
        holder.repoTitle.setText(trendingAndroidRepos.get(position).getRepoNameTitle());
        holder.repoUrl.setText(trendingAndroidRepos.get(position).getUrl());
        holder.repoDescription.setText(trendingAndroidRepos.get(position).getDescription());
        holder.repoDate.setText(trendingAndroidRepos.get(position).getCreatedAt()
                .replace("T","\t\tTime: \t").trim().replace("Z", "").trim());
        holder.repoLanguage.setText(trendingAndroidRepos.get(position).getLanguage());
        holder.repoStarCount.setText(trendingAndroidRepos.get(position).getStargazerCount().toString());

        //Data to be Retrieved when item is clicked on & pass to Detail Activity
        holder.setItemClickListener(new ItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {

                //Our Intent Object
                Intent intent = new Intent(c, ReposDetailActivity.class);

                //Build a new data list for our Detail Activity Extras
                TrendingReposPojo detailRepo = trendingAndroidRepos.get(position);
                //Let's get the String "Extras" we will need
                intent.putExtra("repoTitle", detailRepo.getRepoNameTitle());
                intent.putExtra("repoUrl", detailRepo.getUrl());
                intent.putExtra("repoDescription", detailRepo.getDescription());
                intent.putExtra("repoDate", detailRepo.getCreatedAt());
                intent.putExtra("repoLanguage", detailRepo.getLanguage());
                intent.putExtra("repoStarCount", detailRepo.getStargazerCount().toString());

                //Since we're calling startActivity from an outside Activity
                // we must add this flag.
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                //start The Detail Activity
                c.startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {
        return trendingAndroidRepos.size();
    }
}