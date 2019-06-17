/*
 * *
 *  * Created by Anuraj R (a4anurajr@gmail.com) on 2019
 *  * Last modified 17/6/19 5:41 PM
 *
 */

package com.anuraj.newsapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anuraj.newsapi.R;
import com.anuraj.newsapi.model.NewsModel;

import java.util.ArrayList;

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
        ImageView flag;


        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list_row_item, parent, false);
        // Get the position
       // resultp = data.get(position);

        // Locate the TextViews in listview_item.xml
        news_title = (TextView) itemView.findViewById(R.id.news_title);
        news_time = (TextView) itemView.findViewById(R.id.news_time);

        // Capture position and set results to the TextViews
        news_title.setText(data.get(position).getTitle());
        news_time.setText(data.get(position).getPublishedAt());


        // Capture position and set results to the ImageView
        // Passes flag images URL into ImageLoader.class
     //   imageLoader.DisplayImage(resultp.get(SplashScreen.COMPANY_LOGO), flag);

        // Capture ListView item click
//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {
//                // Get the position
//                resultp = data.get(position);
//                Intent intent = new Intent(context, SingleItemView.class);
//                //pass the selected data to another activity
//                intent.putExtra("companyname",resultp.get(SplashScreen.COMAPANY_NAME));
//                intent.putExtra("companylogo", resultp.get(SplashScreen.COMPANY_LOGO));
//
//                intent.putExtra("certificationname", resultp.get(SplashScreen.CERTIFICATION_NAME));
//                intent.putExtra("partnerId", resultp.get(SplashScreen.PARTNER_ID));
//
//                // Start SingleItemView Class
//                context.startActivity(intent);
//
//            }
//        });
        return itemView;
    }
}