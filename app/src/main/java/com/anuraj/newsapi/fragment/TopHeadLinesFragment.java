/*
 * *
 *  * Created by Anuraj R (a4anurajr@gmail.com) on 2019
 *  * Last modified 15/6/19 2:15 PM
 *
 */

package com.anuraj.newsapi.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.anuraj.newsapi.R;
import com.anuraj.newsapi.Util.NetworkCheck;
import com.anuraj.newsapi.adapter.NewsAdapter;
import com.anuraj.newsapi.model.NewsModel;
import com.anuraj.newsapi.remote.HttpHandler;
import com.anuraj.newsapi.remote.NetworkParsing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.anuraj.newsapi.Util.Constants.NEWS_PUBLISHEDAT;
import static com.anuraj.newsapi.Util.Constants.NEWS_TITLE;
import static com.anuraj.newsapi.Util.Constants.NEWS_URL;
import static com.anuraj.newsapi.Util.Constants.NEWS_URLTOIMAGE;


public class TopHeadLinesFragment extends Fragment {
    View rootView;
    ListView newsList;
    ArrayList<NewsModel> arr;
    ProgressDialog progressDialog;
    public TopHeadLinesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.top_headline_layout, container, false);

        newsList = (ListView) rootView.findViewById(R.id.News_list);

        if(NetworkCheck.isNetworkAvailable(getContext())){
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setMessage("Loading Data");
            progressDialog.show();

            NewsSync newsSync = new NewsSync();
            newsSync.execute();
        }else{
            Toast.makeText(getContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
        }


        return rootView;
    }

    class NewsSync extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        protected String doInBackground(String... args) {
            //Used for Concating the URL, so same class can be used
            NetworkParsing net = new NetworkParsing();
            String url = net.networkSelect("top-headlines","bbc-news");
            HttpHandler handler = new HttpHandler();
            // Making a request to url and getting response
            String jsonResponse = handler.networkCall(url);
            return  jsonResponse;
        }
        @Override
        protected void onPostExecute(String json) {

            if(json.length()>0){

                try {
                    JSONObject jsonResponse = new JSONObject(json);
                    JSONArray jsonArray = jsonResponse.optJSONArray("articles");

                    arr = new ArrayList<NewsModel>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        NewsModel news = new NewsModel();
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        news.setTitle(jsonObject.getString(NEWS_TITLE));
                        news.setPublishedAt(jsonObject.getString(NEWS_PUBLISHEDAT));
                        news.setUrl(jsonObject.getString(NEWS_URL));
                        news.setUrlToImage(jsonObject.getString(NEWS_URLTOIMAGE));
                        arr.add(news);
                    }
                } catch (JSONException e) {
                    Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                }

                NewsAdapter adapter = new NewsAdapter(getContext(), arr);
                newsList.setAdapter(adapter);


            }else{
                Toast.makeText(getContext(), "No items found", Toast.LENGTH_SHORT).show();
            }
            progressDialog.dismiss();
        }



    }
}