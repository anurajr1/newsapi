/*
 * *
 *  * Created by Anuraj R (a4anurajr@gmail.com) on 2019
 *  * Last modified 17/6/19 5:41 PM
 *
 */

package com.anuraj.newsapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anuraj.newsapi.R;
import com.anuraj.newsapi.model.NewsModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.anuraj.newsapi.Util.Constants.NEWS_URL;

public class NewsAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    ArrayList<NewsModel> data;
    public NewsAdapter(Context context,
                           ArrayList<NewsModel> arraylist) {
        this.context = context;
        data = arraylist;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        // Declare Variables
        TextView news_title,news_time;
        ImageView news_image;


        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list_row_item, parent, false);
        // Locate the TextViews in listview_item.xml
        news_title = (TextView) itemView.findViewById(R.id.news_title);
        news_time = (TextView) itemView.findViewById(R.id.news_time);
        news_image = (ImageView) itemView.findViewById(R.id.news_image);

        // Capture position and set results to the TextViews
        news_title.setText(data.get(position).getTitle());
        news_time.setText(data.get(position).getPublishedAt());
        Glide.with(context).load(data.get(position).getUrlToImage()).into(news_image);

        // Capture ListView item click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, NewsAdapter.class);
                //pass the selected data to another activity
                intent.putExtra(NEWS_URL,data.get(position).getUrl());
                // Start SingleItemView Class
                context.startActivity(intent);

            }
        });
        return itemView;
    }
}