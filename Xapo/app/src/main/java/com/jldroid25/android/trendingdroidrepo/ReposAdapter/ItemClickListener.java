package com.jldroid25.android.trendingdroidrepo.ReposAdapter;

import android.view.View;

//Interface to make our RecyclerView / Adapter clickable
public interface ItemClickListener {

    void onItemClick(View v, int position);
}