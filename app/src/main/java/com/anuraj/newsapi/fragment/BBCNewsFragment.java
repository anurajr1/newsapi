/*
 * *
 *  * Created by Anuraj R (a4anurajr@gmail.com) on 2019
 *  * Last modified 15/6/19 12:33 PM
 *
 */

package com.anuraj.newsapi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.anuraj.newsapi.R;
import com.google.android.material.tabs.TabLayout;

public class BBCNewsFragment extends Fragment {

    public BBCNewsFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bbc_layout, container, false);

        // Setting ViewPager for each Tabs
     //   ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
       // setupViewPager(viewPager);
        // Set Tabs inside Toolbar
//        TabLayout tabs = (TabLayout) rootView.findViewById(R.id.bbc_tabs);
//        tabs.setupWithViewPager(viewPager);
        return rootView;
    }

}

