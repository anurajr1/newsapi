/*
 * *
 *  * Created by Anuraj R (a4anurajr@gmail.com) on 2019
 *  * Last modified 15/6/19 2:15 PM
 *
 */

package com.anuraj.newsapi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.anuraj.newsapi.R;

public class TopHeadLinesFragment extends Fragment {
    View rootView;
    public TopHeadLinesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.top_headline_layout, container, false);

        return rootView;
    }
}